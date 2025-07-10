package kbank;

public class BankMan {
	//Field
	String man; //은행직원
	KBBank bank;
	Customer user;
	//Constructor
	public BankMan(){
		
	}
	//Method
	public int moreCheckCash(int cash) {
		if(cash == 0) {
			System.out.println("금액 입력을 하지않으셨습니다.\n 출금하실 금액을 입력해주세요.");
			cash = user.checkCash();
		}else {
			cash = cash;
		}
		return cash;
	}
	
	public int withdrawal(int cash) {
		int outCash = 0;
		outCash = user.cash - cash;
	
		return outCash;
	}
}
