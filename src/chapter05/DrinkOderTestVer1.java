package chapter05;

import java.util.Scanner;

public class DrinkOderTestVer1 {

	public static void main(String[] args) {
		System.out.println("[시작]");
		System.out.println("===== Coffee Menu =====");
		System.out.println("1.☕ 아메리카노 - 2,800원");
		System.out.println("2.🍵 바닐라 라떼 - 3,500원");
		System.out.println("3.🥤 딸기 쉐이크 - 4,000원");
		
		Scanner scan = new Scanner(System.in);
		int sel_menu = 0;	
		String menuName = "";
		String menuPricOutput = "";
		String changeOutput = "";
		String chargeOutput = "";
		int menuPrice = 0;		
		boolean menuFlag = true;
		boolean payFlag = true;
		int charge = 0;
		int change = 0;
		
		//메뉴 주문
		while(menuFlag) {
			System.out.println("주문할 메뉴 번호 입력> ");			
			
			if(scan.hasNextInt()) {
				menuFlag = false;
				sel_menu = scan.nextInt();

				switch(sel_menu) {	
					case 1 : 
						menuName = "☕ 아메리카노";
						menuPrice = 2800;
						System.out.println("선택 완료");
						break;
					case 2 : 
						menuName = "🍵 바닐라 라떼";
						menuPrice = 3500;
						System.out.println("선택 완료");
						break;
					case 3 : 
						menuName = "🥤 딸기 쉐이크";
						menuPrice = 4000;
						System.out.println("선택 완료");
						break;
					default : 
						System.out.println("준비중입니다.");
						menuFlag = true;
				}
				
				//출력용 메뉴가격 저장
				menuPricOutput = String.format("%,d" , new Object[] {Integer.valueOf(menuPrice)});
				
			} else {
				System.out.println("올바르지 않은 값입니다. 다시 입력해주세요.");
				scan.next();
			}
		}
		System.out.println("=> 주문 메뉴 : " + menuName + ", 결제 예정 금액 : " + menuPricOutput + "원");
	
		//결제 기능
		System.out.println("결제할 금액 입력> ");
		while(payFlag) {
			if(scan.hasNextInt()) {
				charge += scan.nextInt();
				chargeOutput = String.format("%,d" , new Object[] {Integer.valueOf(charge)});
				System.out.println("총 입금 금액 : " + chargeOutput);
				
				if(charge >= menuPrice) {
					change = charge - menuPrice;  
					changeOutput = String.format("%,d" , new Object[] {Integer.valueOf(change)});
					System.out.println("=> 결제 완료! 잔돈: " + changeOutput);
					payFlag = false;
				}else {
					System.out.println("금액이 부족합니다. 다시 입력해 주세요.");
				}
			}else {
				System.out.println("올바르지 않은 값입니다. 다시 입력해 주세요.");
				scan.next();
			}
		}		
		System.out.println("[종료]");
		System.out.println("이용해 주셔서 감사합니다.");
		
	}

}
