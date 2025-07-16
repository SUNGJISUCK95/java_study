package chapter11;

import java.util.Scanner;

public class ExceptionTest1 {

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
			System.out.println(numbers[5]);
//			Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
			//ArrayIndexOutOfBoundsException : 배열 에러 //Runtime Exception에 속함
//			at java_study/chapter11.ExceptionTest1.main(ExceptionTest1.java:20)
			
		} catch(ArithmeticException ae) { // 연산 에러
			System.out.println("num2는 0을 입력할 수 없습니다.");
		} catch(ArrayIndexOutOfBoundsException abe) {
			System.out.println("numbers 배열의 범위를 초과 했습니다.");
		}
		
//		int result = 100/0;
//		Exception in thread "main" java.lang.ArithmeticException: / by zero
		//ArithmeticException : 연산에러
//		at java_study/chapter11.ExceptionTest1.main(ExceptionTest1.java:6)
		//에러 위치
//		System.out.println("result : " + result);


	}

}
