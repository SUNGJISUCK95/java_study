package kbank2;

import java.util.Scanner;

public class Customer {
	//Field
	//16
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo accountPaper;
	private Scanner scan;
	
	//Constructor
	//17
	public Customer() {
		
	}
	
	//18
	public Customer(String name, String accountNumber, String password, int money) {
		scan = new Scanner(System.in);
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
	}

	//Method
	//19
	public Scanner getScan() {
		return scan;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
		return accountPaper;
	}

	//22
	public void setAccountPaper(AccountPaperVo accountPaper) { //은행 비치용 입출금용지 가져옴
		this.accountPaper = accountPaper;
		this.accountPaper.setName(this.name);
		this.accountPaper.setAccountNumber(this.accountNumber);
		this.accountPaper.setPassword(this.password);
		this.accountPaper.setMoney(this.money);
		
	}

	
	
}
