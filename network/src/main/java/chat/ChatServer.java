package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	//서버
	private static final int PORT = 6000;
	
	public static void main(String[] args) {
		ServerSocket serversocket = null;
		
		try {
			//서버소켓
			serversocket = new ServerSocket();
			//바인딩
			serversocket.bind(new InetSocketAddress("0.0.0.0",PORT));
			List<Writer> listWriters =null;
			System.out.println("서버 on");
			//accept 요청
			while(true) {
				//소켓
				Socket socket = serversocket.accept();
				listWriters = new ArrayList<Writer>();
				new ChatServerThread(socket,listWriters).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void log(String log) {
		System.out.println("[chat server]"+log);
	}
}
