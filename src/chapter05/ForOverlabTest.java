package chapter05;

import java.util.Scanner;

public class ForOverlabTest {

	public static void main(String[] args) {
		// 2단 ~ 5단 출력		
		Scanner scan = new Scanner(System.in);
		int start = 0;
		int end = 0;
		
		System.out.println("프로그램 종료: start, end 모두 0 입력");
		
		boolean flag = true; 
		
		while(flag) {
			System.out.print("시작단 > ");
			start = scan.nextInt();
			System.out.print("종료단 > ");
			end = scan.nextInt();
			
			// 실행여부 체크
			if(start == 0 && end == 0) {
				//while 블록을 빠져나간 후 종료
				
				//System.out.println("프로그램 종료");
				//System.exit(0);
				
				flag = false;
			}else {
				for(int i=1; i<=9; i++) {
					for(int j=start; j<=end; j++) {
						System.out.print(j + " X " + i + " = " + (i*j) + "\t");
					}
					System.out.println();
				}
				System.out.println("프로그램 종료: start, end 모두 0 입력");
			}	
		}//while
		
		System.out.println("프로그램 종료");
		System.exit(0);
	}//main

}
