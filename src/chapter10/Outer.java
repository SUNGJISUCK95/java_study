package chapter10;

public class Outer {
	String name = "홍길동";
	
	//Inner class
	static class Inner { //Inner 클래스는 객체로 생성된게 아니라 static을 붙여야한다.
		static String name = "이순신"; //static 클래스에서 호출할때는 변수도 static을 붙여야한다.
	}
	
}
