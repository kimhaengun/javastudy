package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;
	private PrintWriter pw = null;
	public ChatServerThread(Socket socket,List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
		
	}

	@Override
	public void run() {
		//상대방 주소 알기
		InetSocketAddress remoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = remoteSocketAddress.getAddress().getHostAddress();
		
		int remoteHostPort = remoteSocketAddress.getPort();
		System.out.println("상대방 주소 확인:"+remoteHostPort);

		try {
			//스트림 얻기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			
			//3요청 처리
			while(true) {
				String request = br.readLine();
				System.out.println("readLine 동작함?"+request);
				if(request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				//4.프로토콜 분석
				
				String[] tokens =request.split(":");
				System.out.println("tokens 정보->"+tokens[0]+":"+tokens[1]);
				System.out.println("message tokens 정보->"+tokens[0]+":"+tokens[1]);
				if("join".equals(tokens[0])) {
					doJoin(tokens[1],pw);
				}
				if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				if("quit".equals(tokens[0])) {
					doQuit(pw);
					break; //종료시 break
				}
		
			}//end while
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(socket != null && socket.isClosed()==false) {
					socket.close();	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}//end run

	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname+"님이 퇴장하셨습니다.";
		broadcast(data);
	}//end doQuit

	private void removeWriter(Writer writer) {
		
		listWriters.remove(writer);
		
	}//end removeWriter

	private void doMessage(String message) {
		System.out.println("===doMessage 탐?===");
		String data = nickname+":"+message;
		System.out.println("메세지 정보:"+data);
		pw.println(data);
		System.out.println("test:"+pw);
		
		
	}//end doMessage

	private void doJoin(String nickname, Writer writer) {
		// TODO Auto-generated method stub
		this.nickname = nickname;
		//broadcast=채팅방 입장 시 모든 사용자에게 메세지 출력
		System.out.println("nickname 받음?"+nickname);
		String data = nickname+"님이 참여하였습니다.";
		broadcast(data);
		
		// writer pool 저장 - wirter인 printWriter를 저장
		addWrite(writer);
		
		//ack - 방 참가 성공
		((PrintWriter) writer).println("join:ok");
		
	}//end dojoin

	private void broadcast(String data) {
		synchronized (listWriters) {
			for(Writer writer : listWriters) { //모든 참가자 --> writer 
				pw = (PrintWriter)writer;
				System.out.println("broadcast pw 확인: "+pw);
				pw.println(data);
			}
		}
	}//end broadcast

	private void addWrite(Writer writer) {
		// 동기화 보장
		synchronized (listWriters) {
			//List에 writer 추가
			listWriters.add(writer);
			ChatServer.log("클라이언트 list:"+listWriters);
		}
	}//end addWrite
	
}//end class
