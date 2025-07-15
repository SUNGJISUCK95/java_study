package chapter10;

//*로 awt에 속한 import 전부 가져옴
//import java.awt.Button;
//import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest {

	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		f.setLayout(new BorderLayout()); //레이아웃 생성
		Button btnClick = new Button("BTN1");
		Button btnClick2 = new Button("BTN2");
		Button btnClick3 = new Button("BTN3");
		p.add(btnClick);	
		p2.add(btnClick2);
		p3.add(btnClick3);
		f.add(p, BorderLayout.NORTH); //btnClick => frame에 버튼넣기 //BorderLayout.NORTH => 버튼을 상단에 넣기
		f.add(p2, BorderLayout.CENTER);
		f.add(p3, BorderLayout.SOUTH);
		f.setTitle("버튼 테스트"); //타이틀
		f.setSize(300, 300); //사이즈
		f.setVisible(true); 
		
		//버튼의 이벤트 처리1 - 내부 클래스를 생성하여 액션 이벤트 처리
		btnClick.addActionListener(new ButtonTest.ButtonActionListener()); //ActionListener 인터페이스를 상속받는 클래스
//		또는
//		ButtonTest.ButtonActionListener action = new ButtonTest.ButtonActionListener();
//		btnClick.addActionListener(action); 
		
		//버튼의 이벤트 처리2 - Anonymouse(익명) 클래스를 생성하여 액션 이벤트 처리
		btnClick2.addActionListener(new ActionListener() { //JVM에서 class AnonymouseActionListener implements Action 이런 모습로 자동으로 만든다
			public void	actionPerformed(ActionEvent e) {
				System.out.println("Button2 Click");
			}
		});
		
		//버튼의 이벤트 처리3 - 람다식(자바 버전 8이상부터) 처리방식을 이용한 이벤트 처리
//		btnClick3.addActionListener((ActionEvent e) -> { 
//			System.out.println("Button3 클릭");
//		});
//		
//		
//		btnClick3.addActionListener(e -> { //매개변수가 하나이면  (ActionEvent )도 생략 가능하다
//			System.out.println("Button3 클릭");
//		});
		
		btnClick3.addActionListener(e -> System.out.println("Button3 클릭")); //{;}도 생략 가능하다
		
		//Frame의 종료 이벤트
		f.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			public void windowDeactivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowOpened(WindowEvent e) {}
		});
		
		
	}//main

	public static class ButtonActionListener implements ActionListener{ 
	//인터페이스로 지정했을 때 그 인터페이스에 관련된 메소드들을 전부 입력해줘야한다.
	//API 사이트에서 ActionListener검색 -> Method -> 전부 입력

		public void actionPerformed(ActionEvent e) {
			System.out.println("마우스 클릭");
		}
	}//ButtonActionListener
}//class
