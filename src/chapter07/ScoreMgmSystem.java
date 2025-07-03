package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 */
public class ScoreMgmSystem {
	//Field : 멤버변수, 전역변수
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);
	Student[] sList = new Student[10];
	boolean insertFlag = true;
	int count = 0;
	
	
	//Constructor
	public ScoreMgmSystem() {
		
	}
	
	
	//Method
//	insert(), update(), remove(), search()
	public void insert() {		
		System.out.println("-- insert --");
		//student = new Student(); //단수 등록		
		
		while(insertFlag) {
			sList[count] = new Student(); //복수 등록
			
			System.out.println("학생명 > ");
			sList[count].name = scan.next();
			
			System.out.println("국어 > ");
			sList[count].kor = scan.nextInt();
			
			System.out.println("영어 > ");
			sList[count].eng = scan.nextInt();
			
			System.out.println("수학 > ");
			sList[count].math = scan.nextInt();
	
			System.out.println("등록 완료");
			
			System.out.println("추가 등록하시겠습니까?(추가: 아무키, 종료: n)");
			if(scan.next().equals("n")){
				insertFlag = false;
			}
			
			count++;
		}
	}
	
	public void show() {
		System.out.println("-------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------");
		for(int i=0; i<count; i++) {
			System.out.print(sList[i].name+"\t");
			System.out.print(sList[i].kor+"\t");
			System.out.print(sList[i].eng+"\t");
			System.out.print(sList[i].math+"\t");
			System.out.print(sList[i].getTot()+"\t");
			System.out.print(sList[i].getAvg()+"\n");
		}
		System.out.println("-------------------");
	}
	
	public void update() {
		System.out.println("update");
	}
	
	public void remove() {
		System.out.println("remove");
	}
	
	public void search() {
		System.out.println("search");
	}
}
