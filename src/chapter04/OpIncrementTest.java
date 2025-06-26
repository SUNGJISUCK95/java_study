package chapter04;

/*
 * 증감 연산자 : ++, --
 */
public class OpIncrementTest {

	public static void main(String[] args) {
		int number = 10;	
		
		System.out.println(++number); //값 증가 후 값을 출력
		System.out.println(number++); //값을 출력한 후 값 증가
		System.out.println(number); //총 증가 값 출력
		
		System.out.println(--number);
		System.out.println(number--);
		System.out.println(number);
	}

}
