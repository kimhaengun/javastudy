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
			//무한 루프 왜 안돌렷냐 ㅏㅏㅏㅏㅏㅏㅏ
			while(true) {
			String message = br.readLine();
			if(message==null) {
				System.out.println("메세지 없음");
				break;
			}else {
				System.out.println(message);
			}
			}//end while
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException : "+e);
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
