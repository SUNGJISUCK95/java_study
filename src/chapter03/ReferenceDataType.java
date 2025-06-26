package chapter03;
import java.util.Scanner; //Scanner는 lang에 있는 함수가 아니므로 호출해서 사용

public class ReferenceDataType {

	public static void main(String[] args) {
		//참조 데이터 타입 정의 : 배열, 클래스, 인터페이스 .. 
		String name = new String("홍길동");
		
		Scanner scan = new Scanner(System.in); //System.in은 키보드 입력 명령어
		
		//String 클래스는 기본형으로도 사용이 가능함
		String name2 = "홍길동";
		
		System.out.println(name);
		System.out.println(scan);
		System.out.println(name2);
		System.out.println(name == name2); //==는 구조 동일 비교 연산자이다.
		//name은 heap에 있는 주소, name2는 stack의 홍길동 문자열이 들어있으므로 false가 반환된다.
	}

}
