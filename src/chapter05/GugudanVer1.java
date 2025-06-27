package chapter05;

import java.util.Scanner;

public class GugudanVer1 {

	public static void main(String[] args) {
		//구구단 2단 출력
		Scanner scan = new Scanner(System.in);
		int start = 0;
		
		while(true) {
			System.out.println("시작단 > ");
			System.out.println("(0입력 시 종료)");
			start = scan.nextInt();
		
			if(start!=0) {
				System.out.println("***************************");
				System.out.println(start + "단");
				for(int i=1; i<=9; i++) {
					System.out.println(start + "X" + i + " = " + (start*i));
				}
			}else {
				System.out.println("종료");
				System.exit(0);
			}
		}//while
	}//main
}//class
