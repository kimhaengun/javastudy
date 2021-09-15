package echo;

import java.util.Scanner;

public class EchoClient {
	//채팅 클라이언트
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print(">");
			String line = scanner.nextLine();
			//소켓 생성 ~
			
			
			
			if("exit".equals(line)) {
				break;
			}
			
		}
		
	}
}
