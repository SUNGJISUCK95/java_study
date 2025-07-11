package kbank2;

public class KBBankTest {

	public static void main(String[] args) {
		//입출금 용지 한장 비치됨
		//10
		AccountPaperVo accountPaper = AccountPaperVo.getInstance(); // 입출금 용지를 만듬
		System.out.println("1 -> " + accountPaper.getName()); //입출금 용지 내용 출력해보기(만든게 없어서 null)
		//13
		BankMan staffPark = new BankMan("박보검"); //은행직원 이름 생성
		staffPark.showAccountList(); //은행원 정보에서 손님정보 메소드 실행해서 출력
		
		//20
		Customer hong = new Customer(null, "kb-1234", "1234", 100); //고객 한명의 정보를 생성 대신 이름은 모름
		
//		고객 홍길동이 출금용지에 이름, 계좌번호, 비밀번호를 작성함 //21
		hong.setAccountPaper(accountPaper); //고객이 입출금용지를 가지고 본인정보를 작성하러감
		System.out.println("2 -> " + accountPaper.getName());
		
//		은행 직원 박보검이 용지를 확인함 //23
//		staffPark.setAccountPaper(hong.getAccountPaper());
		staffPark.checkPaper(hong.getAccountPaper(), hong); //입출금 용지에 작성한 내용을 은행원에게 전달
//								(private 여서 get)
		
//		금액이 누락되어 고객에게 금액을 물어봄 
//		고객이 100만원이라 응답함
//		staffPark.askMoney(hong.answerMoney());
//		
////		은행 직원이 계좌 정보를 검증함 
//		staffPark.check();
//		
////		출금 처리를 하고, 잔액 400만원으로 업데이트함 
//		staffPark.changeProcess();
//		
////		고객이 잔액을 확인하고 퇴장함 [종료] 
//		hong.confirmBalance();
	}

}
