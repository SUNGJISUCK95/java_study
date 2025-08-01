package chapter05;

import java.util.Scanner;

/*
 * 변수 값을 체크하여 실행문
 * switch(변수) {
 * 	case 값1: //변수의 값과 값1일 동일하면 실행문 실행
 * 		실행문1;
 * 		break;
 * 	case 값2: //변수의 값과 값2이 동일하면 실행문 실행
 * 		실행문2;
 * 		break;
 * 		...
 * 	default:
 * 		실행문; //값1, 값2 외의 다른 값인 경우 실행
 * }
 */
public class SwitchTest {

	public static void main(String[] args) {
		//프로그램 실행시 정수값을 입력받아 결과를 출력하시오
		//입력값이 1이면 😃 //window + . 으로 이모지 출력
		//입력값이 2이면 😢
		//입력값이 3이면 😒
		//입력값이 4이면 😜
		//그 외의 숫자는 "준비중" 메세지 출력
		Scanner scan = new Scanner(System.in);
		int number = -1;
		System.out.println("숫자 > ");
		number = scan.nextInt();
		System.out.println(number);
		
		switch (number) {
			case 1 :
				System.out.println("😃");
				break; 
				//break를 안걸면 해당 값 출력 이후 break를 만날때 까지 다른 case값도 출력한다.
			case 2 :
				System.out.println("😢");
				break;
			case 3 :
				System.out.println("😒");
				break;
			case 4 :
				System.out.println("😜");
				break;
			default :
				System.out.println("준비중");	
		}
		System.out.println("-- 종료 --");	
	}

}
