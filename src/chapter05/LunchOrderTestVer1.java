package chapter05;

import java.util.Scanner;

public class LunchOrderTestVer1 {

	public static void main(String[] args) {
		//메뉴판
		System.out.println("***********************");
		System.out.println("\t Welcome to Food Mart");
		System.out.println("***********************");
		System.out.println("\t 1.🍕:100원 \t 2.🍔:200원 \t 3.🍜:300원 \t 4.🍣:400원 \t 5.나가기");
		System.out.println("***********************");
	
		Scanner scan = new Scanner(System.in);
		int menu_num = -1;
		String menuName = "";
		int menuPrice = 0;
		
		System.out.println("메뉴 선택 > ");
		if(scan.hasNextInt()) {
			menu_num = scan.nextInt();
			
			switch (menu_num) {
				case 1 :
					menuName = ("🍕"); 
					menuPrice = 100;
					System.out.println("-- 선택 완료 --");
					break;
				case 2 :
					menuName = ("🍔");
					menuPrice = 200;
					System.out.println("-- 선택 완료 --");
					break;
				case 3 :
					menuName = ("🍜");
					menuPrice = 300;
					System.out.println("-- 선택 완료 --");
					break;
				case 4 :
					menuName = ("🍣");
					menuPrice = 400;
					System.out.println("-- 선택 완료 --");
					break;
				case 5 :
					System.out.println("-- 종료 --");
					System.exit(0); //실행 종료
					break;
				default :
					System.out.println("지정되지 않은 메뉴입니다.");
			}
					
//		System.out.println("메뉴 선택 > ");
//		if(scan.hasNextInt()) { //hasNextInt로 숫자만 입력했을 시 if문 true
//			menu_num = scan.nextInt();
////			System.out.println(menu_num);
//			if(menu_num == 1) {
//				System.out.println("🍕");
//				System.out.println("-- 선택 완료 --");
//			} else if (menu_num == 2) {
//				System.out.println("🍔");
//				System.out.println("-- 선택 완료 --");
//			} else if (menu_num == 3) {
//				System.out.println("🍜");
//				System.out.println("-- 선택 완료 --");
//			} else if (menu_num == 4) {
//				System.out.println("🍣");
//				System.out.println("-- 선택 완료 --");
//			} else if (menu_num == 5) {
//				System.out.println("-- 종료 --");
//				System.exit(0); //실행 종료
//			} else {
//				System.out.println("지정되지 않은 메뉴입니다.");
//			}
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
		}
		System.out.println("주문하신 메뉴는 " + menuName + ", 가격은" + menuPrice + "원 입니다.");
		
		//2. 요금 결제
		System.out.println("결제할 요금 입력 > ");
		int charge = 0;
		int change = 0;
		
		if(scan.hasNextInt()) {
			charge = scan.nextInt();
			
			if(charge > menuPrice) {
				change = charge - menuPrice;
			} else {
				System.out.println("요금이 부족합니다.");
			}
			
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
		}
		
		//3. 주문 내역 : 주문한 메뉴는 (햄버거), 결제금액(), 잔돈(), 입니다.
		System.out.println("주문한 메뉴는 " + menuName + ", 결제금액(" + menuPrice + "), 잔돈(" + change + ") 입니다.");
	}

}
