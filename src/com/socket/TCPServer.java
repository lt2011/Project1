package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	/*
	 * 服务器端（非多线程），与 TCPClient 类为一对
	 * 
	 * 用指定的端口实例化一个SeverSocket对象。服务器就可以用这个端口监听从客户端发来的连接请求。
	 * 调用ServerSocket的accept()方法，以在等待连接期间造成阻塞，监听连接从端口上发来的连接请求。
	 * 利用accept方法返回的客户端的Socket对象，进行读写IO的操作 关闭打开的流和Socket对象
	 */
	public static void main(String[] args) throws IOException {
		// 1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
		ServerSocket serverSocket = new ServerSocket(10086);// 1024-65535的某个端口
		// 2、调用accept()方法开始监听，等待客户端的连接
		while (true) {
			System.out.println("等待客户端连接");
			Socket socket = serverSocket.accept();
			// 3、获取输入流，并读取客户端信息
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is); // 将字节流转换成字符流，方便打印输出
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			StringBuilder recvMsg = new StringBuilder(); // 接收到的信息
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说：" + info);
				recvMsg.append(info); // 将读到的每一行拼接到recvMsg中，因为最后一个跳出while循环的info为null
			}
			socket.shutdownInput();// 关闭输入流
			// 4、获取输出流，响应客户端的请求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write(recvMsg.toString().toUpperCase()); // 将从客户端获得的字母变成大写返回
			pw.flush();

			// 5、关闭资源
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
//			serverSocket.close(); //要在while里一直循环，则不能关闭。

		}
	}

}
