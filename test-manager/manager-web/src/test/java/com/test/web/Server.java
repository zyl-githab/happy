package com.test.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 模拟tomcat监听端口
 * @author Administrator
 *
 */
public class Server{

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8080);
		Socket accept = ss.accept();
		InputStream is = accept.getInputStream();
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		String readLine = null;
		while ((readLine =br.readLine()) != null) {
			System.out.println(readLine);
		}
		ss.close();
	}
}
