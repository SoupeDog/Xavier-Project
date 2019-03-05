package org.xavier.common;

import java.io.*;
import java.net.Socket;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/12/27
 * @since Jdk 1.8
 */
public class A {
    public static void main(String[] args) throws IOException {
        String b="<html>\r\n" +
                "<head><title>301 Moved Permanently</title></head>\r\n" +
                "<body bgcolor=\"white\">\r\n" +
                "<center><h1>301 Moved Permanently</h1></center>\r\n" +
                "<hr><center>nginx/1.14.0</center>\r\n" +
                "</body>\r\n" +
                "</html>\r\n";

        System.out.println(b.length());
        System.out.println(b.getBytes().length);


        Socket socket = new Socket("www.baidu.com", 80);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        BufferedWriter bf = new BufferedWriter(printWriter);
//        String a="GET /main/board/summary/0ef526a3140a46cb94d458f7d506cfe3,744ed9f224d74827a12db8ec97b6975b HTTP/1.1\r\n" +
//                "Host: xavierwang.cn\r\n" +
//                "uId: U00000000\r\n" +
//                "token: 0000\r\n" +
//                "scope: web\r\n" +
//                "secretKey: 23b701cef3a64a0d92c454a09cce0f58\r\n" +
//                "cache-control: no-cache\r\n" +
//                "Postman-Token: 7a909ebd-77c0-4fda-a79e-544f79cd8b02\r\n\r\n";
//        bf.write(a);
        bf.write("GET / HTTP/1.1\r\n" +
                "Host: baidu.com\r\n" +
                "cache-control: no-cache\r\n\r\n");
        bf.flush();

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader is = new BufferedReader(new InputStreamReader(inputStream));
        String temp;
//        stringBuilder.append(is.readLine());
        while ((temp = is.readLine()) != null) {
            stringBuilder.append(temp + "\r\n");
        }
        System.out.println("请求结果:" + stringBuilder.toString());
    }
}
