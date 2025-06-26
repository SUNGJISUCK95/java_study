package chapter03;

/*
 * 변수의 범위 설정 : Global(전역), Local(지역, 로컬)
 */
public class VariableScopeTest {

	//전역 변수
	static int gnumber = 10;
	
    //System.out.println("전역변수 : " + gnumber); //클래스에서는 출력문 호출이 불가능하다
	
	//전역 상수 : START, END
	static final int START = 1;
	static final int END = 0;
	
	//static 메소드는 static이 붙은 전역만 출력이 가능하다.
	public static void main(String[] args) {
		//main method 지역 변수
		int number = 100;
		String str = new String("홍길동"); 
		//heap에 만들어진 문자열은 메소드가 끝나도 stack에서는 사라져도 heap는 그대로 남아있다.
		//하지만 너무 많이 heap에 데이터가 쌓이면 내부적으로 GC에서 알아서 데이터를 삭제한다.
		//직접 처리속도가 느려지면 GC명령어로 heap에 있는 데이터를 처리할 수 있다.
		
		String str2; //1.변수 선언
		
		{
			int number2 = 200;
			str2 = "홍길순"; //2.변수값 할당
			System.out.println(str2);
		}
		
		
//		System.out.println("지역변수 : " + number);
//		System.out.println("전역변수 : " + gnumber);
//		System.out.println("전역상수 : " + START);
//		System.out.println("전역상수 : " + END);
////		System.out.println(number2); //number2는 지역 변수로 상단의 {}안에서 따로 출력문을 입력해줘야 한다.
//		System.out.println("참조변수 : " + str);
	}

}
