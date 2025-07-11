package kbank3;

public class KBBankTest {

	public static void main(String[] args) {
		BankSystem kbsystem = new BankSystem("KB");
		kbsystem.showAccountList(); // 은행시스템 확인
		// 싱글톤
		AccountPaperVo accountPaper = AccountPaperVo.getInstance(); 
		
		BankMan staffPark = new BankMan("박보검", kbsystem); //은행직원 생성 시 고객리스트 정보 가짐
//		은행직원은 고객정보 리스트 출력
		//은행원의 은행시스템(은행시스템에서 가져온 주소값)에서 고객 리스트를 출력한다.
		//한번에 해석하지말고 . 단위로 해성 ex) staffPark.kbsystem -> kbsystem.showAccountList()
//		staffPark.getKbsystem().showAccountList(); 
		
		Customer hong = new Customer("홍길동", "kb-1234", null, 0);
		boolean validateFlag = true;
		hong.setAccountPaper(accountPaper);
		
		//용지 작성내용 확인
//		AccountPaperVo.showInfo(); //또는 hong.getAccountPaper().showInfo();
		
		//은행직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper());
//		(은행원은 값을 받아서 확인해야해서 set) (고객의 정보를 줘야해서 get)
		
		staffPark.validateCheck(); //고객에게 전달받은 출금용지네 빈값이 있는지 체크
		
		while(validateFlag) {
			if(staffPark.validateCheck(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}
		}
		
		staffPark.processWithdrawal();
			
		kbsystem.confirmBalance(hong.getAccountPaper()); //ATM(은행시스템)을 이용하여 잔액을 확인
		
	}

}
