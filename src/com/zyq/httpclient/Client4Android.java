package com.zyq.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.text.style.BulletSpan;

public class Client4Android {
	private int clientPort = 9999;
	private String host = "localhost";
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private String receiveWords;
	
	public Client4Android() throws UnknownHostException, IOException {
		// TODO Auto-generated constructor stub
		socket = new Socket(host, clientPort);
		pw = this.getWriter(socket);
		br = this.getReader(socket);
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException{
		OutputStream out = socket.getOutputStream();
		return new PrintWriter(out);
	}
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream in = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(in));
	}
	
	private void talk(String msg) throws IOException{
		while(msg!=null){
			if(msg.equals("bye")){
				break;
			}
			pw.print(msg);
			pw.flush();
		}
		
	}
	
	private String receive() throws IOException{
		StringBuilder builder = new StringBuilder();
		receiveWords = br.readLine();
		while(receiveWords!=null){
			builder.append(receiveWords);
			receiveWords = br.readLine();
		}
		return receiveWords = builder.toString();
	}
}
