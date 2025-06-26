package chapter04;

/*
 * 논리연산자 : &&(AND), ||(OR), !(NOT)
 * &&, || 연산자는 앞의 식의 결과에 따라 shortcut으로 진행됨
 */
public class OpLogicTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		// AND(&&) : 두 개의 항의 결과가 모두 true인 경우에만 실행결과가 true
		System.out.println((a > b) && (a == 10));
		System.out.println((a > b) && (b == 10));
		System.out.println((a < b) && (a == 10)); 
		//a < b가 false이므로 뒤에는 체크안하고 결과를 출력하는 것을 숏컷이라 한다.
		System.out.println((a < b) && (b == 10));
		
		// OR(||) : 두 개의 항의 결과 중 하나라도 true이면 실행결과가 true
		System.out.println((a > b) || (a == 10));
		System.out.println((a > b) || (b == 10));
		System.out.println((a < b) || (a == 10));
		System.out.println((a < b) || (b == 10));
		
		// NOT(!) : 결과를 반대의 boolean 값으로 변경
		System.out.println(!(!(a > b) || !(a == 10)));
		//System.out.println(!a); //a는 int 타입으로 NOT 연산자가 적용되지 않음 

	}

}
