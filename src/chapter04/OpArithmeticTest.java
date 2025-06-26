package chapter04;

/*
 * 사칙 연산자 : +, -, *, /, %
 */
public class OpArithmeticTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
		System.out.println("number1 + number2 = " + (number1 + number2));
		// 문자열 다음에 +로 변수끼리 더해도 문자로 인식되어 출력되기 때문에 변수끼리 ()로 묶어 따로 계산한다.
		
		System.out.println("number1 - number2 = " + (number1 - number2));
		System.out.println("number1 * number2 = " + (number1 * number2));
		System.out.println("number1 / number2 = " + (number1 / number2));
		System.out.println("number1 % number2 = " + (number1 % number2));
		// %는 나누고 남은 값을 결과로 출력 ex) 5를 2로 나누면 나머지값 1

	}

}
