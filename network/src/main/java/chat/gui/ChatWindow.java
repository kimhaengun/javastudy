package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		//KeyListener
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode==KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		//2. IOStream가져오기 br,pw
		
		//3. Chat ClientThread 생성하기
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메시지 : "+message);
		textField.setText("");
		textField.requestFocus();
		//message 프로토콜 pw --> 서버
		
		//Receive Thread에서 서버로부터 받은 메세지가 있다고 치고,
		updateTextArea("마이콜:"+message); //스레드안에 있어야함
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	private void finish() {
		System.out.println("소켓 닫기 or 방나가기 프로토콜 구현");
		System.exit(0);
	}
	
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			updateTextArea(".......");
		}
		
	}
}
