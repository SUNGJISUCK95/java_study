package chapter11;

import java.util.Scanner;

/**
 * Exception 객체 생성 > 다른 메소드에세 예외처리를 넘김
 */
public class ExceptionTest4 {

	//checkAge 메소드
	//try, catch로 처리
	public static void checkAge(int age) {
		try {
			if(age<0) {
				throw new Exception("나이는 0보다 커야함 (예외 발생)"); //직접 빨간 에러 메세지를 만드는 것
			} else {
				System.out.println("age : " + age);
			}
		}catch(Exception e) {
			System.out.println("age 값은 0보다 커야함");
			e.printStackTrace();
		}
	}
	
	//throws Exception으로 Exception처리를 main에게 넘김
	public static void checkAge(int age, String name) throws Exception{
			if(age<0) {
				throw new Exception("나이는 0보다 커야함 (예외 발생)"); //직접 빨간 에러 메세지를 만드는 것
			} else {
				System.out.println("age : " + age);
			}
	}
	
	public static void main(String[] args) {//main은 실행의 최초 지점이므로 throws Exception으로 넘길 수 없다.
		//키보드를 통해 나이를 입력받아 체크함
		Scanner scan = new Scanner(System.in);
		System.out.print("나이 > ");
		int age = scan.nextInt();
		
//		checkAge(age);
		
		try {
			checkAge(age, "홍길동");
		} catch(Exception e) {
			System.out.println("age 값은 0보다 커야함");
		} finally {
			scan.close();
			System.out.println("-- 프로그램 종료 --");
		}
	}//main

}
