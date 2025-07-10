package kbank;

import java.util.Scanner;

public class Customer {
	//Field
	Scanner scan = new Scanner(System.in);
	String name; //입출 이름
	String accountNum; //입출 계좌번호
	int cash = 5000000;	
	int password; //입출 비번
	KBBank bank;
	//Constructor
	public Customer() {
		
	}

	//Method
	
	public int checkCash() {
		System.out.println("출금액 : ");
		int outCash = 0;
		if(scan.hasNextInt()) {
			outCash = scan.nextInt();
		}else {
			System.out.println("잘못된 입력 입니다. 재입력 해주세요.");
			bank.outcash();
		}
		return outCash;
	}
	
	public String checkName() {
		System.out.println("성명 : ");		
		name = scan.next();
		if(name == "" || name == null) {
			System.out.println("빈값은 입력할 수 없습니다.");
			checkName();
		}
		return name;		
	}
	
	public String checkaccountNum() {
		System.out.println("계좌번호");
		accountNum = scan.next();
		if(accountNum == "" || accountNum == null) {
			System.out.println("빈값은 입력할 수 없습니다.");
			checkaccountNum();
		}
		return accountNum;		
	}
	
	public int checkPass() {
		if(scan.hasNextInt()) {
			System.out.println("비밀번호");
			password = scan.nextInt();
		}else {
			System.out.println("비밀번호는 숫자만 입력 가능합니다.\n 재입력 해주세요.");
			checkPass();
		}
		
		if(password == 0) {
			System.out.println("빈값은 입력할 수 없습니다.");
			checkPass();
		}
		
		return password;
	}
}
