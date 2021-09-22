package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 6000;

	public static void main(String[] args) {
		Socket socket = null;
		String nickname = null;
		// 서버에 던지는 데이터 형식 Nickname:data
		try {
			// 키보드 연결만 하자!;;
			Scanner scanner = new Scanner(System.in);

			// 소켓 생성
			socket = new Socket();
			// 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			System.out.print("닉네임>>");
			nickname = scanner.nextLine();
			pw.println("join:" + nickname);
//			System.out.println(nickname);
			String line = br.readLine();
				if ("join:ok".equals(line)) {
					System.out.println("방 입장 완료");
				}else {
					System.out.println("방 입장 실패");		
				}


			new ChatClientThread(socket).start();
			
			// 키보드 입력 처리 하기
			while (true) {
				String input = scanner.nextLine();
				if ("quit".equals(input)) {
					pw.println("quit");
					break;
				}else{
					// 메시지 처리
					pw.println("message:"+input);
				}

			} // end while

		} catch (IOException e) {
			log("error" + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end finally
	} // end main

	public static void log(String log) {
		System.out.println("[클라이언트]" + log);
	}// end log
}// end class
