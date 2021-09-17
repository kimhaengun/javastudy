package chat.gui;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		//1.소켓 생성
		
		//2.서버 연결
		
		//3.I/O 스트림 받아오기
		//4.join Protocol
//		    --> 결과 String lime = br.readLine();
		
		String  line ="JOIN:OK";
		if("JOIN:OK".equals(line)) {
			new ChatWindow(name).show();	
		}
	}

}
