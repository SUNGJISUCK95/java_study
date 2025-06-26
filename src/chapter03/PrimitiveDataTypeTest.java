package chapter03;

public class PrimitiveDataTypeTest {

	public static void main(String[] args) {
		boolean run = true; //논리형
		
		//정수형 데이터 타입
		byte b = 1;
		short s = 10;
		int i = 100;
		long l = 1000;
		long l2 = 1000L;
		
		//실수형 데이터 타입
		float f = 10.0f; //소수점 기본이 double로 인식되어 float면 끝에 f붙여줘야 함
		double d = 100.0;
		
		//문자리터럴 데이터 타입
		char c = 'a'; //문자들이 아스키 코드들로 저장되어있음
		char c2 = 'A';
		int c_asc = c; //int로 문자를 아스키 코드로 변환
		int c_asc2 = c2; 
		char str = '홍';
//		char str2 = "홍";
		
		//상수 정의 : 프로그램 시작부터 종료까지 같은 값을 가지며, 상수명은 전체 대문자로 선언
		//프로그램 시작 : START(1), 종료 : END(0)
		final int START = 1; //final을 선언하면 해당 변수의 값은 바뀌지않는다.	
		//START = 2;		
		final int END = 0;
		
		System.out.println("boolean --> " + run);
		System.out.println("byte : " + b);
		System.out.println("short : " + s);
		System.out.println("int : " + i);
		System.out.println("long : " + l);
		System.out.println("long : " + l2);
		
		System.out.println("float : " + f);
		System.out.println("double : " + d);		
		
		System.out.println("char : " + c);
		System.out.println("char : " + c2);
		System.out.println("char ascii : " + c_asc); //97
		System.out.println("char ascii : " + c_asc2); //65
	
		System.out.println("START : " + START);
		System.out.println("END : " + END);
	}
	

}
