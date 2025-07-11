package kbank3;

/**
 * 입출금 용지
 */
public class AccountPaperVo {
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	//용지를 만드는 방법
	//변수 지정 생성자 생성 (private 생성자면 변수도 private)
	private static AccountPaperVo accountPaper = new AccountPaperVo();
	
	private AccountPaperVo() {}
	
	public static void showInfo() {
		System.out.println("==========================================");
		System.out.print(accountPaper.getName() +"\t");
		System.out.print(accountPaper.getAccountNumber() +"\t");
		System.out.print(accountPaper.getPassword() +"\t");
		System.out.print(accountPaper.getMoney() +"\n");
		System.out.println("==========================================");
	}
	
	//생성한 용지를 get으로 공유
	public static AccountPaperVo getInstance() {
		return accountPaper;
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
	
	
}