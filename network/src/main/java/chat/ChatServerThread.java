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
	private PrintWriter pw;
	
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
		
		try {
			//스트림 얻기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			
			//3요청 처리
			while(true) {
				String request = br.readLine();
				
				if(request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				//4.프로토콜 분석
				
				String[] tokens =request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1],pw);
				}
				if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				if("quit".equals(tokens[0])) {
					doQuit(pw);
				}else {
					ChatServer.log("에러:알수 없는 요청("+tokens[0]+")");
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
		String data = message;
		if(data == null) {
			ChatServer.log("읽을 데이터가 없습니다.");
		}
		System.out.println(nickname+":"+data);
		pw.println(data);
		
	}//end doMessage

	private void doJoin(String nickname, Writer writer) {
		// TODO Auto-generated method stub
		this.nickname = nickname;
		//broadcast=채팅방 입장 시 모든 사용자에게 메세지 출력
		String data = nickname+"님이 참여하였습니다.";
		broadcast(data);
		
		// writer pool 저장 - wirter인 printWriter를 저장
		addWrite(writer);
		
		//ack - 방 참가 성공
		pw.println("join:ok");
		pw.flush();
		
	}//end dojoin

	private void broadcast(String data) {
		synchronized (listWriters) {
			for(Writer writer : listWriters) { //모든 참가자 --> writer 
				pw = (PrintWriter)writer;
				pw.println(data);
				pw.flush();
			}
		}
	}//end broadcast

	private void addWrite(Writer writer) {
		// 동기화 보장
		synchronized (listWriters) {
			//List에 writer 추가
			listWriters.add(writer);
			
		}
	}//end addWrite
	
}//end class
