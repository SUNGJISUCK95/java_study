package chapter17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {		
		try {
			String id = "홍길동";
			final String HOST = "localhost";
			final int PORT = 9000;
			Frame f = new Frame(id);
			Panel p = new  Panel();
			f.setLayout(new BorderLayout());
			TextArea ta = new TextArea();
			TextField tf = new TextField(40);
			Button send = new Button("전송");
			Button button1 = new Button("종료");
			ta.setEditable(false); //TextArea에 글자를 쓰지는 못하고 출력만 가능한 명령어
			tf.setText("[" + id + "]");
			p.add(tf);
			p.add(send);
			
			Socket s = new Socket(HOST, PORT); //localhost, 127.0.0.1, 192.168.10.53
			System.out.println("클라이언트 접속");
			
//			InputStream input = s.getInputStream(); //1KB 크기
//			OutputStream output = s.getOutputStream(); //읽은 바이트 수 반환
			// ↓ DataInputStream이 InputStream에 상속(자식)되어있는 클래스 이므로 아래로 업그레이드 가능
			DataInputStream input = new DataInputStream(s.getInputStream()); //1KB 크기
			DataOutputStream output = new DataOutputStream(s.getOutputStream()); //읽은 바이트 수 반환
			
			
			//업그레이드를 함으로 써 아래 코드 생략 가능
//			byte[] buffer = new byte[1024];
//			int bytesRead = input.read(buffer);
//			
//			if(bytesRead != -1) {
//				String receivedMessage = new String(buffer, 0, bytesRead, "UTF-8");
//				ta.append("서버로부터 받은 메세지 : " + receivedMessage); //TextArea에 해당 내용출력
//			}
			
			new ServiceThread(input, ta).start();
			
			f.add(p, BorderLayout.NORTH);
			f.add(ta, BorderLayout.CENTER);
			f.add(button1, BorderLayout.SOUTH);
			f.setSize(400, 500);
			f.setVisible(true);
			
			//전송 버튼 이벤트
			send.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//전송 버튼 클릭 --> 서버로 tf 데이터 전송
						
						output.writeUTF(tf.getText()); //Client에서 적은 내용 서버에 보냄
						tf.setText("[" + id + "]");
					}catch(Exception e2){
						e2.printStackTrace();
					}
				}
			});
			
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("클라이언트 종료");
						output.writeUTF("exit");
						System.exit(0);
					} catch(Exception e2) {
						
					}
				}
			});
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}

}

class ServiceThread extends Thread {
	DataInputStream input;
	TextArea ta;
	
	public ServiceThread(DataInputStream input, TextArea ta) {
		this.input = input;
		this.ta = ta;
	}
	
	public void run() {
		try {
			while(true) {
				ta.append(input.readUTF() + "\n"); ////서버에서 Client에서 적은 내용 돌려 받음
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
