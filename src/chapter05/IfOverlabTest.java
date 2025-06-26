package chapter05;

import java.util.Scanner;

public class IfOverlabTest {

	public static void main(String[] args) {
		Scanner scan2 = new Scanner(System.in);
		int math_score = 0, eng_score = 0;
		System.out.println("수학점수 > ");
		math_score = scan2.nextInt(); //int로 변수 지정하면 그 뒤로는 int 안붙여도 됨 
		
		Scanner scan3 = new Scanner(System.in);
		System.out.println("영어점수 > ");
		eng_score = scan3.nextInt();
		
		//1. 중첩 if
		if (math_score >= 60) {
			if(eng_score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
		} else {
			System.out.println("불합격");
		}

		//2. 논리연산자 &&를 이용하기 if ~ else
		if((math_score) >= 60 && (eng_score >= 60)) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
