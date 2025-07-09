package vending_machin_ver1;

import java.util.Scanner;

public class User {
	//Field
	Scanner scan;
	String name;
	
	//Constructor
	public User() {
		this("홍길동");
	}
	
	public User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	//Method
	
	
	/*
	 * 동전 입력
	 */
	public int insertCoin() {
		int resultCoin = 0;
		System.out.println("["+name+"] 동전입력> ");
		if(scan.hasNextInt()) {
			//100원 , 500원만 입력가능
			int coin = scan.nextInt();
			resultCoin = coin;
//			if(coinCheck(coin)) {
//				
//			}			
		}else {
			System.out.println("잘못된 입력입니다. 재입력 해주세요.");
			scan.next();
			insertCoin();
		}
		return resultCoin;
	}
	
	/*
	 * 메뉴 선택
	 */
	public int selectMenu() {
		int menu = 0;
		System.out.println("["+name+"] 메뉴선택> ");
		if(scan.hasNextInt()) {
			menu = scan.nextInt();		
		}else {
			System.out.println("잘못된 입력입니다. 재입력 해주세요.");
			scan.next();
			selectMenu();
		}
		return menu;
	}
	
	
}
