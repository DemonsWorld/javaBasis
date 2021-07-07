package com.zlm;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author Kakrolot
 * @date 2021/6/23 20:37
 */
public class ThreadDay3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallImplements c1 = new CallImplements("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","1.jpg");
        CallImplements c2 = new CallImplements("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","2.jpg");
        CallImplements c3 = new CallImplements("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","3.jpg");

        ExecutorService ser = Executors.newFixedThreadPool(3);

        Future<Boolean> submit1 = ser.submit(c1);
        Future<Boolean> submit2 = ser.submit(c2);
        Future<Boolean> submit3 = ser.submit(c3);

        Boolean aBoolean = submit1.get();
        Boolean aBoolean1 = submit2.get();
        Boolean aBoolean2 = submit3.get();

        ser.shutdown();

    }

}

class CallImplements implements Callable<Boolean>{
    private String url;
    private String name;

    public CallImplements(String url, String name) {
        this.url = url;
        this.name = name;
    }



    @Override
    public Boolean call() throws Exception {
        FileDownLoader fileDownLoader = new FileDownLoader();
        fileDownLoader.download(url,name);
        System.out.println("下载文件名为"+name);
        return true;
    }
}


