package kbank3;

import java.util.Scanner;

public class Customer {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo accountPaper;
	private Scanner scan;
	
	public Customer() {
		
	}
	
	public Customer(String name, String accountNumber, String password, int money) {
		this.name = "[고객 : " + name + "]";
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
		this.scan = new Scanner(System.in);
		System.out.println(this.name + " 입장");
	}
	
	/**
	 * 은행직원이 유효성 체크 후 빠진 고객정보 물어보면, 해당하는 답변을 입력한다.
	 * @return
	 */
	public AccountPaperVo answer(int checkResult) {
		switch(checkResult) {
		case BankMan.ACCOUNT_NAME :
			System.out.print(this.name + "고객명> ");
			accountPaper.setName(scan.next());
			break;
		case BankMan.ACCOUNT_NUMBER :
			System.out.print(this.name +  "계좌번호> ");
			accountPaper.setAccountNumber(scan.next());
			break;
		case BankMan.ACCOUNT_PASSWORD :
			System.out.println(this.name +  "비밀번호> ");
			accountPaper.setPassword(scan.next());
			break;
		case BankMan.ACCOUNT_MONEY :
			System.out.print(this.name +  "금액> ");
			accountPaper.setMoney(scan.nextInt());
			break;
		}
		
		return accountPaper;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNum() {
		return accountNumber;
	}

	public void setAccountNum(String accountNum) {
		this.accountNumber = accountNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public AccountPaperVo getAccountPaper() {
		System.out.println(this.name + " 은행직원에게 출금용지를 전달");
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper; 
		//▲이게 없으면 주소공유가 안됨 
		//은행원한테 내용적은 용지를 못줌
		this.accountPaper.setName(this.name);
		this.accountPaper.setAccountNumber(this.accountNumber);
		this.accountPaper.setPassword(this.password);
		this.accountPaper.setMoney(this.money);
		
		System.out.println(this.name + "출금정보 작성 완료");
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	
}
