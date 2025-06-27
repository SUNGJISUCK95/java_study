package chapter05;

public class FormatTest {

	public static void main(String[] args) {
		// 정수를 출력 시 3자리씩 콤마를 구분하는 메소드
		int a = 2800;
		String aa = String.format("%,d" , new Object[] { Integer.valueOf(a) }); //숫자 금액으로 문자열 포맷
		System.out.println(aa);

	}

}
