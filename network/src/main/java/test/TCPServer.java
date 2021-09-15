package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 서버 생성 시
			//1.서버 소켓 생성
			serverSocket = new ServerSocket();
			//2.바인딩(Binding)
			//Socket에 InetSocketAddress(IPAddress+port)
			//IPAddress : 0.0.0.0 --> 모든 IP연결 허용
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000));
			
			//3.accept
			//클라이언트로 부터 연결 요청을 기다린다.
			Socket socket = serverSocket.accept();//Blocking
			
			//상대편의 소켓 주소
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			//inetSocketAddress 부모(inetAddress)의 getHostAddress 가져오기
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			
			System.out.println("[server] connected by client["+remoteHostAddress+":"+remoteHostPort+"]");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[server error]:"+e);
		}finally {
			try {
				if (serverSocket !=null && serverSocket.isClosed()==false) {
					serverSocket.close();	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
