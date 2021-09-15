package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	//채팅 클라이언트
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=6000;
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner =null;
		try {
		scanner = new Scanner(System.in);
		//1.소켓 생성
		socket = new Socket();
		//2.연결
		socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
		log("연결 성공");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

		while(true) {
			System.out.print(">");
			String line = scanner.nextLine();
			
			if("exit".equals(line)) {
				break;
			}
			//데이터 읽기
			pw.println(line);
			String data = br.readLine();
			if(data == null) {//데이터가 없을 경우
				log("서버랑 연결이 끊김");
				break;
			}
			//데이터 있을 경우
			System.out.println("<"+data);
		}
		}catch (SocketException e) {
			// TODO: handle exception
			log("갑자기 서버랑 끊김:"+e);
		}catch (IOException e) {
			// TODO: handle exception
			log("error:"+e);
		}finally {
			try {
				if(scanner!=null) {
					scanner.close();
				}
				if(socket!=null && socket.isClosed()==false) {
					socket.close();	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static void log(String log) {
		System.out.println("[Echo Client]"+log);
	}
}
