package myrpc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ServerSocket server = new ServerSocket(3233);
        Socket socket = server.accept();

        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            while (true) {
                byte[] buf = new byte[1024];
                in.read(buf);//阻塞等待调用
                String json = new String(buf);
                System.out.println(json);
                JSONObject object = JSON.parseObject(json);
                //通过反射调用方法，返回结果
                String className = object.getString("clazz");
                String methodName = object.getString("method");//没传方法参数过来就不接了
                Class<?> aClass = Class.forName(className);
                Object o = aClass.newInstance();
                Method method = aClass.getMethod(methodName);
                String res = (String) method.invoke(o);
                //result可以通过一个对象封装，在这里简便起见直接返回一个string

                out.write(res.getBytes());
            }

        } finally {
            socket.close();
            server.close();
        }
    }
}
