package chapter06;

import java.util.Scanner;

/*
 * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직
 */
public class ScoreTestVer1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = null;
		int[] scoreList = new int[5];
		String[] subjectlist = {"국어", "영어", "수학"};

		System.out.print("학생명> ");
		name = scan.next();
		double tot = 0.0;
		int avg = 0;
		
		for(int i=0; i<scoreList.length; i++) {
			if(i<subjectlist.length) {
				System.out.println(subjectlist[i] + " 점수> ");
				scoreList[i] = scan.nextInt();
				tot += scoreList[i];				
			}else {
				scoreList[scoreList.length-2] = (int)tot; 
				//double타입인 tot의 값을 scoreList는 int타입이므로 int로 강제 형변환
				scoreList[scoreList.length-1] = avg = (int)tot/subjectlist.length;
				i = scoreList.length; //또는 break;				
			}
		}
		
		
		
		//2. 데이터 출력 : 학생명, 국어, 영어, 수학 점수 출력
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.print(name+"\t");
		for(int score : scoreList) {
			System.out.print(score+"\t");
		}
	}

}
