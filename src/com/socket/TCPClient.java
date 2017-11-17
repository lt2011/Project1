package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*基于TCP协议，实现字母的大写转换，整个流程是客户端发送字符串给服务器，
服务器将字符串转换为全部大写后，发送回客户端，客户端进行显示。*/
public class TCPClient {

	/*
	 * 客户端 用服务器的IP地址和端口号实例化Socket对象。 调用connect方法，连接到服务器上。
	 * 获得Socket上的流，把流封装进BufferedReader/PrintWriter的实例，以进行读写
	 * 利用Socket提供的getInputStream和getOutputStream方法，通过IO流对象，向服务器发送数据流
	 * 关闭打开的流和Socket。
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1、创建客户端Socket，指定服务器地址和端口
		Socket socket = new Socket(InetAddress.getLocalHost(), 10086);
		// 2、获取输出流，向服务器端发送信息
		OutputStream os = socket.getOutputStream();// 字节输出流
		PrintWriter pw = new PrintWriter(os);// 将输出流包装成打印流

		// 从键盘获取输入
		System.out.println("请输入发送内容：");
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		// pw.write("用户名：admin；密码：admin");
		pw.write(bReader.readLine());
		pw.flush();
		socket.shutdownOutput();

		// 3、获取输入流，并读取服务器端的响应信息
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is); // 将字节流转换成字符流，方便打印输出
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while ((info = br.readLine()) != null) {
			System.out.println("我是客户端，服务器说：" + info);
		}

		// 4、关闭资源
		br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();

	}
}
