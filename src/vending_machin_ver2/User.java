package vending_machin_ver2;

import java.util.Scanner;

public class User {
	//Field
	//이름, 입력을 위한 스캐너 객체
	String name;
	Scanner scan;
	
	//Constructor
	public User() {
		this("김유신");
	}
	public User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	public String getName() {
		return name;
	}
	
	public Scanner getScan() {
		return scan;
	}
	
	//Method
	
	//동전 입력
		public int insertCoin() {
			int resultCoin = 0; //결과 코인값 초기화
			System.out.println("투입 동전>");
			if(scan.hasNextInt()) { //숫자체크
				int coin = scan.nextInt(); //코인값 입력
				resultCoin = coin;	//입력된 코인값 결과에 저장			
			}else {
				System.out.println("잘못된 입력입니다. 재입력 해주세요.");
				scan.next(); //무조건 빈 입력값 넣어줘야함
				insertCoin();
			}
			return resultCoin;
		}
		
	//메뉴 선택
		public int menuChoice() {
			int resultMenu = 0;
			System.out.println("메뉴 선택>");
			if(scan.hasNextInt()) {
				int menu = scan.nextInt();
				resultMenu = menu;
			}else {
				System.out.println("잘못된 입력입니다. 재입력 해주세요.");
				scan.next(); //무조건 빈 입력값 넣어줘야함
				menuChoice();
			}
			return resultMenu;
		}
	//getter 메소드
}
