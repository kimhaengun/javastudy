package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	//클라이언트
	//다른 PC연결시 IP 설정해주면됨.
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=5000;
	public static void main(String[] args) {
		Socket socket = null;
		try {
			//1. 소켓 생성
			socket = new Socket();
			
			//2.서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			
			//3. I/O Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4.쓰기
			String data ="Hello World";
			os.write(data.getBytes("UTF-8"));
			
			//5.읽기
				//5.데이터 읽기
				byte[] buffer = new byte[256]; //임시 버퍼 공간 생성
				int readByteCount = is.read(buffer); //Blocking
				if(readByteCount == -1) {
					// 클라이언트가 정상적으로 종료가 됨.(close() 호출)
					System.out.println("[server] 정상(close 호출 뒤) 종료");
				}
			data = new String(buffer,0,readByteCount,"UTF-8");
			System.out.println("[client] 받은 데이터:"+data);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("[client] 비정상 종료:"+e);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[client error]:"+e);
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
	}
}
