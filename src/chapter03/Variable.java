package chapter03;
//import java.lang.String; //lang이 아닌 함수는 import해야한다.

public class Variable {
	public static void main(String[] args) {
		// 기본 자료형 변수 정의
		int age = 10;
		double aged = 10; //실수는 정수를 입력해도 에러안뜸
		boolean flag = true; //true(1), false(0)
		char name = '홍';
		char name2 = '길';
		char name3 = '동';
		System.out.println(age);
		System.out.println(aged);
		System.out.println(flag);
		System.out.print(name);
		System.out.print(name2);
		System.out.println(name3);
		
		// 참조 자료형 변수 정의
		String sname = "홍길동"; //기본형이므로 stack에 저장됨
		String sname2 = new String("홍길동"); //참조형이므로 heap에 저장됨
		System.out.println(sname);
		System.out.println(sname2);		
		
		//** String 클래스는 기본형과 참조형으로 모두 사용 가능.
	}
}
