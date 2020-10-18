package com.aaa.gh.classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @Author guohang
 * @Date 2020/10/17 15:59
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Object obj = new HelloClassLoader().findClass("Hello").newInstance();
            Class<?> aClass = obj.getClass();
            Method hello1 = aClass.getMethod("hello", null);
            hello1.invoke(obj,null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = "C:/Users/Administrator/Desktop/hello/Hello.xlass";
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(filePath));
            for (int i = 0; i < bytes.length; i++) {
                byte a = (byte) (255 - bytes[i]);
                bytes[i] = a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,bytes,0,bytes.length);
    }

}



