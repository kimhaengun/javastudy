package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		//=========서버 소켓==========
		try {
			// 서버 생성 시
			//1.서버 소켓 생성
			serverSocket = new ServerSocket();
			//2.바인딩(Binding)
			//Socket에 InetSocketAddress(IPAddress+port)
			//IPAddress : 0.0.0.0 --> 모든 IP연결 허용
			//내 IP 설정 : InetAddress.getLocalHost().getHostAddress()
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
			try {
				//========데이터 소켓========
			//4.I/O Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			while(true) { //무한 루프
				//5.데이터 읽기
				byte[] buffer = new byte[256]; //임시 버퍼 공간 생성
				int readByteCount = is.read(buffer); //Blocking
				if(readByteCount == -1) {
					// 클라이언트가 정상적으로 종료가 됨.(close() 호출)
					System.out.println("[server] 정상(close 호출 뒤) 종료");
					break;
				}
				
				//처음(0)부터 끝(readByteCount)까지
				String data =new String(buffer,0,readByteCount,"utf-8");
				System.out.println("[server] 데이터 받음:"+data);
			}
			}catch(SocketException e) {
				System.out.println("[server error] 비정상적으로 종료됨 :"+e);
			}catch(IOException e) {
				System.out.println("[server error]:"+e);
			}finally {
				//데이터 소켓 종료
				try {
					if(socket!=null && socket.isClosed()==false) {
						socket.close();	
					}
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
			
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
