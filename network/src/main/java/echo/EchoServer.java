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

			// 3.accept
			Socket socket = serverSocket.accept();
			try {
//			InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

				// 데이터 읽기
				while (true) {
					String data = br.readLine();
					if (data == null) {// 읽을 데이터가 없슴
						log("close by client");
						break;
					}
					log("받은 데이터:" + data);
					pw.println(data);
				}

			} catch (IOException e) {
				// TODO: handle exception
				log("error :" + e);
			} finally {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

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
