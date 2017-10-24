package myrpc;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Consumer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 3233);
        try {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            while (true) {
                //调用方法，构造一个invokeMessga，将调用信息（调用方法、传递参数、封装类）封装，利用fastjson格式解析，outputStream转为二进制传输
                //invokeMessage,tojson,tobytes,write
                InvokeMessage iv = new InvokeMessage("myrpc.serviceImpl.BaseServcieImpl", "getService", "protocol", null);
                System.out.println(JSON.toJSONString(iv));
                out.write(JSON.toJSONString(iv).getBytes());

                byte[] res = new byte[1024];//
                in.read(res);
                System.out.println("结果：" + new String(res));//返回的json格式的方法调用结果

                Thread.sleep(3000);
            }
        } finally {
            socket.close();
        }
    }
}
