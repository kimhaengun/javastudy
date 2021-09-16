package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

//accept 스레드
public class EchoServerreceiveThread extends Thread{
	private Socket socket; //accept소켓
	
	public EchoServerreceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//connet 연결되면
		//상대편의 소켓 주소
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		//inetSocketAddress 부모(inetAddress)의 getHostAddress 가져오기
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		EchoServer.log("연결된 client["+remoteHostAddress+":"+remoteHostPort+"]");
		
		try {
//		InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 데이터 읽기
			while (true) {
				String data = br.readLine();
				if (data == null) {// 읽을 데이터가 없슴 String=null
					EchoServer.log("close by client");
					break;
				}
				EchoServer.log("받은 데이터:" + data);
				pw.println(data);
			}
		
		} catch (IOException e) {
			// TODO: handle exception
		 	EchoServer.log("error :" + e);
		} finally {
			if (socket != null && socket.isClosed() == false) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
