package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private Socket socket;
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			String message = br.readLine();
			if(message==null) {
				System.out.println("메세지 없음");
			}else {
				System.out.println(message);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException : "+e);
		}
	}

}
