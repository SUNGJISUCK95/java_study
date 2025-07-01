package chapter06;

import java.util.Scanner;

/*
 * 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 점수를 입력
 * - 입력받은 과목의 총점과 평균을 구함
 * - 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 입출력을 위해서 각 배열의 주소를 통일한다.
 * 
 * 프로그래밍 방식 : 구조적(Structured) 방식, 객체지향적(Object Oriented) 방식
 */

public class ScoreTestVer2 {

	public static void main(String[] args) {
		System.out.println("===============================");
		System.out.println(" 더조은 고등학교 1-1 성적관리 프로그램");
		System.out.println("===============================");
		
		//Step1 : 배열 선언		
		Scanner scan = new Scanner(System.in);
		System.out.println("크기입력> ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		//Step2 : 데이터 입력 - 실행시 외부에서 입력
		for(int i=0; i<nameList.length; i++){
			System.out.println("학생명>");
			nameList[i] = scan.next();
			System.out.println(nameList[i] + "의 국어점수> ");
			korList[i] = scan.nextInt();
			System.out.println(nameList[i] + "의 영어점수> ");
			engList[i] = scan.nextInt();
			System.out.println(nameList[i] + "의 수학점수> ");
			mathList[i] = scan.nextInt();
			totList[i] = korList[i] + engList[i] + mathList[i];
			avgList[i] = totList[i]/3;
			System.out.println("계속 입력 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
			if(scan.next().equals("n")) {
				//종료
				break; //또는 i = nameList.length;
			}

		}
		
		//Step3 : 데이터 출력
		System.out.println("===============================");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("===============================");
		for(int i=0; i<nameList.length; i++) {
			if(nameList[i] != null) {				
				System.out.print(nameList[i]+"\t");
				System.out.print(korList[i]+"\t");
				System.out.print(engList[i]+"\t");
				System.out.print(mathList[i]+"\t");
				System.out.print(totList[i]+"\t");
				System.out.print(avgList[i]+"\n");
			}
		}
		
		//Step4 : 데이터 조회
		//조회할 학생명 입력
		
		boolean searchFlag = true;
		
		while(searchFlag) {
			System.out.println("학생명 검색> ");
			String searchName = scan.next();
			//nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
			int searchIndex = -1;
			int count = 0;
			for(String name : nameList) { 
			//nameList의 배열 수 만큼 for문 루프
				if(name != null) { 
				//nameList의 배열 수는 5개이므로 무조건 5번 돌아서 null값 체크
					if(name.equals(searchName)) {
						//searchName에 입력한 이름과 nameList에 있는 이름 동일체크	
						searchIndex = count;
						//같으면 배열번호 저장
						count++;
					}
				}
			}
			System.out.println("검색결과 주소 : " + searchIndex);
			
			//Step5 : 데이터 조회 결과 출력
			System.out.println("===============================");
			System.out.println("\t\t검색 결과");
			System.out.println("===============================");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("===============================");
			System.out.print(nameList[searchIndex]+"\t");
			System.out.print(korList[searchIndex]+"\t");
			System.out.print(engList[searchIndex]+"\t");
			System.out.print(mathList[searchIndex]+"\t");
			System.out.print(totList[searchIndex]+"\t");
			System.out.print(avgList[searchIndex]+"\n");
			
			System.out.println("추가로 검색하시겠습니까?(검색:아무키, 종료:n)");
			if(scan.next().equals("n")) {
				//종료
				searchFlag = false; //또는 break;
			}
		}
		
		System.out.println("프로그램 종료");
	
	}//main

}//class
