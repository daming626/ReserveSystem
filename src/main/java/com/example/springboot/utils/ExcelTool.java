package com.example.springboot.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 解析Excel文件单元格内容
 *
 * @Author: liyh
 * @Date: 2020/10/24 17:05
 */
public class ExcelTool {
    public static final String EMPTY = "";
    private static final String POINT = ".";

    /**
     * 获得path的后缀名
     *
     * @param path 文件路径
     * @return 路径的后缀名
     */
    public static String getPostfix(String path) {
        if (path == null || EMPTY.equals(path.trim())) {
            return EMPTY;
        }
        if (path.contains(POINT)) {
            return path.substring(path.lastIndexOf(POINT) + 1, path.length());
        }
        return EMPTY;
    }

    /**
     * 解析xls和xlsx不兼容问题
     *
     * @param pfs
     * @param workbook
     * @param file
     * @return
     */
    public static Workbook getWorkBook(POIFSFileSystem pfs, Workbook workbook, MultipartFile file) throws IOException {//POI解析文档
        String filename = file.getOriginalFilename();//得到上传时的文件名。
//        if (filename.endsWith("xls")) {
//            System.out.println("已判断出文件类型xls");
//             pfs = new POIFSFileSystem(file.getInputStream());
//            System.out.println("xls转inputstream");
//            workbook = new HSSFWorkbook(pfs);
//            System.out.println("xls格式转换完成");
//            return workbook;
//        } else if (filename.endsWith("xlsx")) {
        if (filename.endsWith("xlsx")) {
            try {
                System.out.println("file转inputstream");
                workbook = new XSSFWorkbook(file.getInputStream());
                System.out.println("inputstream转workbook");
                return workbook;
            } catch (IOException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
