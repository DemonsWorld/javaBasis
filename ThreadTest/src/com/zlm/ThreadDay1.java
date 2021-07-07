package com.zlm;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Kakrolot
 * @date 2021/6/22 22:48
 */
public class ThreadDay1 extends Thread{
    private String url;
    private String name;

    public ThreadDay1(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        FileDownLoader fileDownLoader = new FileDownLoader();
        fileDownLoader.download(url,name);
        System.out.println("下载文件名为"+name);
    }

    public static void main(String[] args) {
        ThreadDay1 t1 = new ThreadDay1("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","1.jpg");
        ThreadDay1 t2 = new ThreadDay1("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","2.jpg");
        ThreadDay1 t3 = new ThreadDay1("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class FileDownLoader{
     public void download(String url,String name){
         try {
             FileUtils.copyURLToFile(new URL(url), new File(name));
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
