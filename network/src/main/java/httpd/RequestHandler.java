package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT="./webapp";
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
					
			String req =null;
			while(true) {
				String line = br.readLine();
				//브라우저가 연결을 끊으면,
				if (line==null) {
					break;
				}
				
				//SimpleHttpServer에서는 요청의 헤더만 읽음
				if("".equals(line)) {
					break;
				}
				//헤더의 첫번째 라인만 읽음
				if(req ==null) {
					req=line;
					break;
				}
			}
			//요청 처리
//			consoleLog(req);
			String[] tokens = req.split(" ");
			if("GET".equals(tokens[0])) {
				consoleLog("req : "+tokens[1]);
				responseStaticeResource(outputStream,tokens[1],tokens[2]);
			}else {
				//method : POST, PUT, DELETE, HEAD, CONNET
				//SimpleHttpServer 에서는 무시(400 bad Request 처리)
				response400Error(outputStream,tokens[1],tokens[2]);
//				outputStream.write( "HTTP/1.1 400 Bad Request\n".getBytes( "UTF-8" ) );
//				outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//				outputStream.write( "\n".getBytes() );
//				//body
//				outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );
			}
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write( "HTTP/1.1 200 OK\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\n".getBytes() );
//			//body
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );

		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void response400Error(OutputStream outputStream, String url, String protocol) throws IOException {
		// TODO Auto-generated method stub
		
		//welcome file set= index.html
		if("/".equals(url)) {
			url = "/index.html";
		}		
		File file = new File(DOCUMENT_ROOT+url);
		if(!file.exists()) {//주소가 존재하지 않으면
//			response404Error(outputStream,url,protocol);
			return;
		}
		byte[] body = Files.readAllBytes(file.toPath()); //IOException
		String contentType = Files.probeContentType(file.toPath()); //MINE Type을 알려줌
		outputStream.write((protocol+" 400 Bad Request\n").getBytes( "UTF-8" ) );
		outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
		outputStream.write( "\n".getBytes() );
		//body
		outputStream.write(body);
	}

	private void responseStaticeResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// TODO Auto-generated method stub
		
		//welcome file set= index.html
		if("/".equals(url)) {
			url = "/index.html";
		}
		// ./webapp/index.html
		File file = new File(DOCUMENT_ROOT+url);
		if(!file.exists()) {//주소가 존재하지 않으면
			response404Error(outputStream,url,protocol);
			return;
		}
		
		//nio , 전체 길이를 읽어뿜
		byte[] body = Files.readAllBytes(file.toPath()); //IOException
		String contentType = Files.probeContentType(file.toPath()); //MINE Type을 알려줌
		outputStream.write((protocol+ " 200 OK\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\n".getBytes() );
		//body  --> byte 이기 때문에 UTF-8 설정할 필요가 읎다
		outputStream.write(body);
	}

	private void response404Error(OutputStream outputStream, String url, String protocol) {
		// TODO Auto-generated method stub
		
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
