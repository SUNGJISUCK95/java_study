package chapter11;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("num1 > ");
		int num1 = scan.nextInt();
		
		System.out.print("num2 > ");
		int num2 = scan.nextInt();
		
		try {
			int result = num1/num2;
			System.out.println("result : " + result);
			
			int[] numbers = {1,2,3};
			System.out.println(numbers[0]);
			System.out.println(numbers[5]);
			
		} catch(Exception e) { // 모든 에러 발생 시 작동
			System.out.println("예외 발생");
			e.printStackTrace(); //어떤 에러와 몇번째 줄에 일어났는지 알려줌
		} finally { //마지막에 무조건 실행
			scan.close(); //Scanner 종료
			System.out.println("-- 프로그램 종료 --");
		}

	}

}
