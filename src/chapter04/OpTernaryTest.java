package chapter04;

import java.util.Scanner;
//아래 Scanner를 클릭한 뒤 ctrl + shift + o를 눌러서 import를 자동을로 할 수 있다.

/*
 * 삼항연산자 : (조건식) ? 결과1 : 결과2 ;
 */
public class OpTernaryTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("점수 > ");
		int score = input.nextInt();
		
		//score가 60점 이상이면 "합격", 이하면 "불합격"임, 해당 결과를 result 변수에 대입함
		String result = (score >= 60) ? "합격" : "불합격" ;
		System.out.println("결과 = " + result);
	
	}

}
