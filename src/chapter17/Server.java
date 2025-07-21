package chapter17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 멀티 채팅 서버 구현
 */
public class Server {

	public final static int PORT = 9000;
	public static ArrayList<ClientHandler> List = new ArrayList<ClientHandler>(); 
	//Client가 접속 될 때마다 정보를 저장하는 배열 
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행 중 : " + PORT);
			System.out.println("클라이언트 접속 대기 중");
			
			while(true) { //while문으로 Client에서 서버에 접속해도 계속해서 다른 Client가 접속할 수 있도록 대기
				Socket s = server.accept(); //클라이언트 접속 대기 중
				System.out.println("클라이언트 접속");
				
				//클라이언트 별로 접속하고 별도 종료 진행
				ClientHandler ch = new ClientHandler(s);
				ch.start();
				List.add(ch);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//main

}//server

class ClientHandler extends Thread {
	Socket s;
//	OutputStream output;
//	InputStream input;
	// ↓ Server와 Client보면 서로 전달방식이 같아야 통신가능
	DataOutputStream output;
	DataInputStream input;
	
	public ClientHandler(Socket s) {
		try {
			this.s = s;
//			this.output = s.getOutputStream(); //전송
//			this.input = s.getInputStream(); //수신
			// ↓ Server와 Client보면 서로 전달방식이 같아야 통신가능
			this.output = new DataOutputStream(s.getOutputStream()); //전송
			this.input = new DataInputStream(s.getInputStream()); //수신
			
			String str = "[서버]환영합니다.";
//			output.write(str.getBytes());
			// ↓ Server와 Client보면 서로 전달방식이 같아야 통신가능
			output.writeUTF(str);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {			
			boolean flag = true;
			while(flag) {
				String recievedMsg = input.readUTF(); //Client가 작성한 값 받는 부분
				if(recievedMsg.equals("exit")) {
					flag = false;
				}else {
					Server.List.forEach(ch -> {
						try {
							ch.output.writeUTF(recievedMsg); 
							//받은 값을 다시 Client에 보내는 부분
							//현재 접속한 클라이언트에게 만 전송	
						} catch(Exception e){
							e.printStackTrace();
						}
					});
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
