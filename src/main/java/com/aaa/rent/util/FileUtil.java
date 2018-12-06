package com.aaa.rent.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * className:FileUtil
 * discription:
 * author:luRuiHua
 * createTime:2018-11-23 08:34
 */
public class FileUtil {

    public static String uploadFile(String savaPath, MultipartFile multipartFile) {
        //获取源文件名称，
        String originalFilename = multipartFile.getOriginalFilename();
        //获取源文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接新文件名称
        //UUID.randomUUID() spring提供的随机数
        String newFileName = UUID.randomUUID()+suffix;
        //实例化一个文件，实际上没有创建该文件，读取的时候才会真正创建
        File file = new File(savaPath+ newFileName);
        try {
            //调用spring提供的方法进行文件读写
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    return newFileName;
    }

    /**
     * 通用下载方法
     * @param filename
     * @param response
     * @return
     */
    public static String downLoad(String filename, HttpServletResponse response){
        String filePath = "D:/imgs" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");//MIME类型
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
            /*int i = bis.read(buffer);
            while(i != -1){
                os.write(buffer);
                i = bis.read(buffer);
            }*/
                int i=0;
                while((i = bis.read(buffer))!=-1){
                    os.write(buffer,0,i);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("222");
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
