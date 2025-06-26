package chapter03;

/*
 * 제어문자 실습
 */
public class EscapeTest {

	public static void main(String[] args) {
		String greet = "안녕하세요~\n\n반갑습니다.\t홍길동입니다.";
		String name = "\"홍길동\"";//문자열에 "또는'를 넣고 싶으면 \를 써서 입력해주면 오류를 방지할 수 있다.
		
		System.out.println(greet);
		System.out.println(name);
	}

}
