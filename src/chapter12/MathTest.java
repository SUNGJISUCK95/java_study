package chapter12;

public class MathTest {

	public static void main(String[] args) {
		//모든 메소드가 static으로 정의되어 있음 : 클래스명.메소드명()
		System.out.println(Math.abs(-100)); //절대값 출력
		System.out.println(Math.floor(123.4567)); //소수점아래 제거
		System.out.println(Math.max(100, 200)); //최대값
		System.out.println(Math.min(100, 200)); //최소값
		System.out.println(Math.random());
		System.out.println(Math.floor(Math.random() * 1000)); //정수 두자리 랜덤
		System.out.println(Math.round(123.567)); //정수 전까지 반올림
	}

}
