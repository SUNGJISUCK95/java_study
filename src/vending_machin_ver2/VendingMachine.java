package vending_machin_ver2;

import java.util.Scanner;

import commons.Menu;

public class VendingMachine {
	//Field
	Scanner scan = new Scanner (System.in);
	String name;
	String title; //자판기 회사명
	int price;
	int no;
	int totalCoin;
	int orderCount;
	int change;
	User user; //자판기 사용자명
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유"};
	int[] priceList = {300,300,400,200};
	Menu[] menuList;
	Menu[] orderList;
	Menu orderMenu;
	
	//Construtor
	public VendingMachine() {
//		this("만남의 광장");
	}
	
	public VendingMachine(String title, User user) {
		this.title = title; //자판기 회사명 받기
		this.user = user; //자판기 사용자명 받기
		creatMenu();
		menuList();
		coinCheck();
	}
	//Method
	
	//메뉴 생성
	public void creatMenu() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i+1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
	
	public void createOrderList(int totalCoin) {
		orderList = new Menu [menuList.length];
		//orderList를 Menu타입 배열로 만든다.
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				//menuList의 price값이 totalCoin보다 작거나 같으면
				orderList[orderCount] = menu;
				//그 배열의 주소값들을 orderList에 넣기
				orderCount++;
			}
		}
	}
	
	//메뉴 출력
	public void menuList() {
		System.out.println("====== " + title + "Coffee Machine ======");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ". ");
			System.out.print(menu.getName() + "\t");
			System.out.println(menu.getPrice() + "원");		
		}
	}
	
	//동전 체크
	public void coinCheck() {
		System.out.println("동전을 넣어주세요.");
		int coin = user.insertCoin();
		if(coin == 100 || coin == 500) {
			totalCoin += coin;
			System.out.println("총 투입액 =" + totalCoin);
			if(totalCoin >= 200) {
				System.out.println("메뉴(n), 동전 투입(아무키)");
				if(user.scan.next().equals("n")) { //입력받은 값이 n인지 확인
//					showMenuList("주문가능메뉴");
					createOrderList(totalCoin);
					menuCheck();					
				}else {
					coinCheck();
				}
			}else {
				System.out.println("최소 주문금액은 200원입니다. 추가로 동전을 투입해주세요.");
				coinCheck();
			}
		}else {
			System.out.println("100원, 500원만 투입 가능합니다. 다시 입력해주세요.");
			coinCheck();
		}
	}
	
	//메뉴 검사
	public boolean menuInspect(int menuNo) {
		boolean result = false;
		
		for(int i=0; i<orderCount; i++) {
			Menu menu = orderList[i];
			if(menu.getNo() == menuNo) {
				result = true;
			}
		}
		return result;
	}
	
	//메뉴 체크
	public void menuCheck() {
//		System.out.println("메뉴를 선택해주세요.");
		for(Menu menu : orderList) {
			if(menu != null) {
			//orderList의 배열 생성은 menuList와 같으므로 null값은 출력에서 걸러줘야함
				System.out.print(menu.getNo() + ". ");
				System.out.print(menu.getName() + "\t");
				System.out.println(menu.getPrice() + "원");
			}
		}
		int menuNo = user.menuChoice();
		if(menuInspect(menuNo)) {
			placeOrder(menuNo);
		}else {
			menuCheck();
		}
//		if(menuNo < menuList.length) {
//			
//		}else {
//			System.out.println("메뉴 준비중입니다. 재선택 해주세요.");
//			menuCheck();
//		}
	}
	
	public void placeOrder(int menuNo) {
		//주문가능한 메뉴리스트에서 선택한 menuNo를 비교하여 메뉴주소를 orderMenu에 대입
		for(Menu menu : orderList) {
			if(menu != null) { 
			// menu의 주소값이 null이 아닐결우로 주소값 확인
			// 이래야 null 에러가 발생하지 않음
				if(menu.getNo() == menuNo) {
					orderMenu = menu;					
				}
			}else {
				break;
			}			
		}
		System.out.println("주문완료");
		processPayment();
	}
	//주문
	
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(price <= totalCoin) {
				change = totalCoin - price;
				System.out.println("결제 완료");
				init();
			}
		}
		finalCheck();
	}
	//결제 
	
	//종료 후 객체 초기화
	public void init() {
		orderCount = 0;
		orderList = null;
		orderMenu = null;
		totalCoin = 0;
	}
	
	//종료
	public void finalCheck() {
		//잔돈이 최소 주문금액보다 크면 계속 주문
		int price = menuList[menuList.length-1].getPrice();
		if(change >= price) {
			//계속 메뉴 선택
			totalCoin = change;
			System.out.println("잔돈 : " + change);
			System.out.println("추가 주문(아무키), 종료(n)");
			if(user.scan.next().equals("n")) {
				System.out.println("결제 내역");
				System.out.println("잔돈 : " + change);
				System.out.println("이용해 주셔서 감사합니다.");
				System.exit(0);
			}else {
				createOrderList(totalCoin);
				menuCheck();
			}			
		}else {
			System.out.println("결제 내역");
			System.out.println("잔돈 : " + change);
			System.out.println("이용해 주셔서 감사합니다.");
		}
	}
}
