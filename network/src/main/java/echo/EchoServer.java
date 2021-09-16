package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	// 채팅 서버
	private static final int PORT = 6000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1.소켓 생성
			serverSocket = new ServerSocket();
			// 2.bind
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts ... [port:" + PORT + "]");

			while(true) {
				Socket socket = serverSocket.accept();
				new EchoServerreceiveThread(socket).start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			log("error:" + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[echo server]" + log);
	}
}
