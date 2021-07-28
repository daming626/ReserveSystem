package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.bean.Results;
import com.example.springboot.bean.Users;
import com.example.springboot.mapper.ExcelMapper;
import com.example.springboot.service.ExcelService;
import com.example.springboot.utils.ExcelTool;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExcelServiceImpl extends ServiceImpl<ExcelMapper, Users> implements ExcelService {

    private NumberFormat numberFormat = null;//NumberFormat是所有数值格式的抽象基类。该类提供了格式化和分析数值的接口.

    @Override
    public Results importProject(MultipartFile file) {
        // 解析Excel数据
        System.out.println("开始解析数据");
        Results r = readDataFromExcel(file);

        List list = (List) r.getData();
        List<Users> items = list;
        System.out.println("数据已放入集合");

        if (items == null || items.size() <= 0) {
            return Results.error("没有数据！！！");
        }

        //查询之前是否存在项目清单项,在这里插入！！！！！！！

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("state", 0);
        List<Users> beforeItems = baseMapper.selectList(wrapper);//默认提供了增删改查基础方法，开发人员对于这些基础操作不需要写SQL进行处理操作,这里意思select * from tb——user where state=0

        System.out.println("已查询到数据库");
        //如果存在，判断两个集合中是否有相同的项目序号
        if (beforeItems != null && beforeItems.size() > 0) {
            List<String> beforeUserId = beforeItems.stream().map(Users::getUserid).collect(Collectors.toList());//stream()把元数据转化成流，map用于映射每个元素到对应的结果，collect关闭流
            List<String> afterUserId = items.stream().map(Users::getUserid).collect(Collectors.toList());//这里需要改，为什么这里不能是主键

            for (String vo : beforeUserId) {
                if (afterUserId.contains(vo)) {
                    return Results.error(vo + "：该项目序号已经存在");
                }
            }
        }


        // 如果没有序号相等，则插入数据表格中的数据，然后重新读取
        for (Users item : items) {
            // 保存数据
            int insert = baseMapper.insertProjectItem(item.getUserid(), item.getUsername(), item.getPassword(), item.getRealname(), item.getSex(), item.getTclass(), item.getGrade(), item.getContacts());
            if (insert <= 0) {//上面这里调用ExcelMapper的insertProjectItem去xml执行sql语句
                return Results.error("导入失败");
            }
        }
        return Results.success("导入成功");
    }

    /**
     * 解析Excel数据
     */
    public Results readDataFromExcel(MultipartFile file) {
            POIFSFileSystem pfs = null;
            Workbook workbook = null;
            try {
                // 解析xls和xlsx不兼容问题
                workbook = ExcelTool.getWorkBook(pfs, workbook, file);
                System.out.println("已转为workbook");
            } catch (IOException e) {
                e.printStackTrace();
                return Results.error("模板保存异常。");
            }
        if (workbook == null) {
            return Results.error("请使用模板上传文件");
        }
        // 判断有记录的列数
        if (workbook.getSheetAt(0).getRow(0).getPhysicalNumberOfCells() != 8) {
            return Results.error("请使用类型所对应的模板");
        }

        numberFormat = NumberFormat.getNumberInstance();//返回当前默认语言环境的通用数值格式。

        List<Users> list = new ArrayList<>();
        // 获取表格第一个sheet的内容
        Sheet sheetAt = workbook.getSheetAt(0);
        System.out.println("获取第一个表的内容");
        // 获得sheet总行数
        int lastRowNum = sheetAt.getLastRowNum();
        if (lastRowNum < 1) {
            return Results.error("数据错误");
        }
        // 开始读取,不读取表头所以从第二行开始
        for (int i = 1; i <= lastRowNum; i++) {
            // 获取每一行
            Row row = sheetAt.getRow(i);
            // 行为空不读取
            if (row == null) continue;//行为空跳出循环
            Cell cell = row.getCell(0);
            //列为空不读取
            if (cell == null || StringUtils.isEmpty(convertData(cell))) continue;//StringUtils.isEmpty判断字符串是否为空，convertData是数据转换

            // 创建对象封装行数据
            Users user = new Users();
            // 创建一个集合根据下标来确定每个单元格对应对象的什么属性
            List<String> rowList = new ArrayList<>();
            //添加数据
            for (int j = 0; j < 8; j++) {
                Cell cellOne = row.getCell(j);
                try {
                    String item = convertData(cellOne);
                    rowList.add(item);
                } catch (Exception e) {
                    System.out.println("-------------------Err-----------------------");
                    System.out.println(i + "行" + j + "列数据转换出现异常");
                    rowList.add("");
                }
            }
            //规避行数数据后几行为空
            if (rowList.size() < 8) {
                for (int k = 0; k < 8 - rowList.size(); k++) {
                    rowList.add("");
                }
            }

            // 添加数据
            user.setUserid(rowList.get(0).trim());
            user.setUsername(rowList.get(1).trim());
            user.setPassword(rowList.get(2).trim());
            user.setRealname(rowList.get(3).trim());
            user.setSex(rowList.get(4).trim());
            user.setTclass(rowList.get(5).trim());
            user.setGrade(rowList.get(6).trim());
            user.setContacts(rowList.get(7).trim());
            list.add(user);
        }
        System.out.println("文件解析成功");
        return Results.success("解析成功", list);
    }

    /**
     * 表格数据转换
     */
    public String convertData(Cell cell) {
        String str = "";

        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                //判断是否是整数
                str = numberFormat.format(cell.getNumericCellValue());
                break;
            case STRING:
                str = cell.getStringCellValue();
                break;
            case _NONE:
                str = "";
                break;
            case BLANK:
                str = "";
                break;
            case FORMULA:
                try {
                    str = String.valueOf(cell.getNumericCellValue());
                } catch (IllegalArgumentException e) {
                    str = String.valueOf(cell.getRichStringCellValue());
                }
                break;
            default:
                str = "";
        }
        return str;
    }
}
