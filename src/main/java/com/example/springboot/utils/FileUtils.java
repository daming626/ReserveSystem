package com.example.springboot.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: liyh
 * @Date: 2020/11/4 16:10
 */

public class FileUtils {

    /**
     * 下载文件
     * @param request
     * @param response
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String downloadFiles(HttpServletRequest request, HttpServletResponse response, String fileName){

        if (StringUtils.isEmpty(fileName)) {//判断filename是否为空，isEmpty是判断为空，isnotEmpty是非空
            return "文件名称为空";
        }

        //设置文件路径
        ClassPathResource classPathResource = new ClassPathResource("templates/" + fileName);//创建ClassPathResource对象时，我们可以指定是按Class的相对路径获取文件还是按ClassLoader来获取。
        File file = null;
        try {
            file = classPathResource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
            return "文件不存在";
        }

        response.setHeader("content-type", "application/octet-stream");//整句话意思是告知客户端响应正文类型
        // 设置强制下载不打开
        response.setContentType("application/force-download");//意思是下载弹出的确定保存提示框。".dll"="application/x-msdownload"
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);//文件下载，指定默认名


        //声明一个byte数组作为buffer，然后循环将文本内容循环读入到buffer中，并将buffer转换为字符串，打印到控制台。
        byte[] buffer = new byte[1024];//缓冲器
        InputStream fis = null;
        BufferedInputStream bis = null;//提供缓冲输入流功能,相对于普通输入流的优势是，它提供了一个缓冲数组，每次调用read方法的时候，它首先尝试从缓冲区里读取数据，若读取失败（缓冲区无可读数据），则选择从物理数据源（譬如文件）读取新数据（这里会尝试尽可能读取多的字节）放入到缓冲区中，最后再将缓冲区中的内容部分或全部返回给用户.

        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();//用于输出字符流数据或者二进制的字节流数据都可以
            int i = bis.read(buffer);
            while (i != -1) {//读取到文件尾部时read方法将返回-1
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "文件下载成功";
    }

    /**
     * 判断文件大小
     *
     * @param file  文件
     * @param size  限制大小
     * @param unit  限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(MultipartFile file, int size, String unit) {
        if (file.isEmpty() || StringUtils.isEmpty(size) || StringUtils.isEmpty(unit)) {
            return false;
        }
        long len = file.getSize();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }
}
