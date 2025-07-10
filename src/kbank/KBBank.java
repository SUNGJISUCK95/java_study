package kbank;

import java.util.Scanner;

public class KBBank {
	//Field
	Scanner scan = new Scanner(System.in);
	String name; //입출 이름
	String accountNum; //입출 계좌번호	
	int password; //입출 비번
	int cash; //금액
	Customer user;
	BankMan man;
	//Constructor
	public KBBank() {
		
	}
	
	public KBBank(String title) {		
		System.out.println(title + "은행에 어서오세요.");
		CustomerCheck();
//		outcash();
	}
	//Method
	public void outcash() {
		System.out.println("출금하실 금액을 입력해주세요.");
		cash = user.checkCash();		
	}
	
	public void CustomerCheck() {
		int outCash = 0;
		System.out.println("출금을 위해 본인 확인을 진행해주세요.");
//		name = user.checkName();
//		accountNum = user.checkaccountNum();
//		password = user.checkPass();		
//		cash = user.checkCash();
		
		System.out.println("성명 : ");		
		name = scan.next();
		if(name == "" || name == null) {
			System.out.println("빈값은 입력할 수 없습니다.");
//			checkName();
		}
		
		System.out.println("계좌번호 : ");
		accountNum = scan.next();
		if(accountNum == "" || accountNum == null) {
			System.out.println("빈값은 입력할 수 없습니다.");
//			checkaccountNum();
		}
		
		System.out.println("비밀번호 : ");
		if(scan.hasNextInt()) {			
			password = scan.nextInt();
		}else {
			System.out.println("비밀번호는 숫자만 입력 가능합니다.\n 재입력 해주세요.");
//			checkPass();
		}
		
		if(password == 0) {
			System.out.println("빈값은 입력할 수 없습니다.");
//			checkPass();
		}
		
		System.out.println("출금액 : ");
//		int outCash = 0;
		if(scan.hasNextInt()) {
			outCash = scan.nextInt();
		}else {
			System.out.println("잘못된 입력 입니다. 재입력 해주세요.");
//			bank.outcash();
		}
		
		cash = 5000000 - outCash;
		
//		cash = man.moreCheckCash(cash);
//		
//		outCash = man.withdrawal(cash);
		
		outBank(outCash);
	}

	public void outBank(int outCash) {
		System.out.println("출금 금액 : " + outCash);
		System.out.println("남은 잔고 : " + cash);
		System.out.println("이용해주셔서 감사합니다.");
	}
}
