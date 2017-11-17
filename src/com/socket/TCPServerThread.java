package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的服务端，与TCPClient配对
 * 
 * @author liutao2017年7月5日
 */
public class TCPServerThread extends Thread {
	private Socket client;

	public TCPServerThread(Socket c) {
		this.client = c;
	}

	public void run() {
		try {
			//1. 组装输入流和输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			// Mutil User but can't parallel

			//2. 从输入流获得客户端的输入
			String info = null;
			StringBuilder recvMsg = new StringBuilder(); // 接收到的信息
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说：" + info);
				recvMsg.append(info); // 将读到的每一行拼接到recvMsg中，因为最后一个跳出while循环的info为null

				//3. 经输出流返回信息给客户端
				pw.println(recvMsg.toString().toUpperCase()); //也可以用pw.write()
				pw.flush();
				/*if (info.equals("end"))
					break;*/
			}
			client.close();
		} catch (IOException ex) {
		} finally {
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10086);
		while (true) {
			// transfer location change Single User or Multi User

			TCPServerThread mc = new TCPServerThread(server.accept());
			mc.start();
		}
	}

}
