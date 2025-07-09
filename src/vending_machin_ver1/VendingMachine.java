package vending_machin_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유"};
	int[] priceList = {300,400,300,200};
	Menu[] menuList;
	Menu[] orderMenuList; //user가 주문가능한 메뉴
	String title; //자판기 회사명
	User user; //자판기 사용자
	int totalCoin;
	int orderCount;
	Menu orderMenu;
	int change; //잔돈
	
	static final int EXIT = 9; //클래스명, 상수명
	
	public VendingMachine(User user) {
		this("막심", user);
	}
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	/*
	 * 메뉴 체크
	 */
	public boolean menuCheck(int menuNo) {
		boolean result = false;
	
		for(int i=0; i<orderCount; i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) {
				result = true;
			}
		}
		
		return result;
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() { //정확한 메뉴 선택
		//총 투입 금액에 맞는 메뉴를 보여준다
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("취소는 " + VendingMachine.EXIT + "번을 입력해주세요.");
		
		int menuNo = user.selectMenu();
		if(menuNo != VendingMachine.EXIT) {
			if(menuCheck(menuNo)) {
				placeOrder(menuNo);
			}else {
				selectMenu();
			}
		}else {
			System.out.println("***********************");
			System.out.println("동전을 반환합니다.");
			System.out.println("반환 동전 : " + totalCoin);
			System.exit(0);
		}
	}
	
	/*
	 * 주문 
	 */
	public void placeOrder(int menuNo) {
		//주문가능한 메뉴리스트에서 선택한 menuNo를 비교하여 메뉴주소를 orderMenu에 대입
		for(Menu menu : orderMenuList) {
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
	
	/*
	 * 결제
	 */
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(price <= totalCoin) {
				change = totalCoin - price;
				System.out.println("결제완료");
				init();
				//사용한 객체 초기화 > orderMenuList, orderMenu, totalCount
			}
		}		
		finalCheck();
	}
	
	/*
	 * 종료 후 객체 초기화 
	 */
	public void init() {
		orderCount = 0;
		orderMenuList = null;
		orderMenu = null;
		totalCoin = 0;
	}
	
	/* 
	 * 종료
	 */
	public void finalCheck() {
		//잔돈이 최소 주문금액보다 크면 계속 주문
		int price = menuList[menuList.length-1].getPrice();
		if(change >= price) {
			//계속 메뉴 선택
			totalCoin = change;
			System.out.println("잔돈 : " + change);
//			System.out.println("메뉴 선택(n), 동전 투입(아무키)> ");
//			if(user.scan.next().equals("n")) {
				createOrderMenuList(totalCoin);
				showMenuList("주문가능메뉴");
				selectMenu();
//			}else {
//				checkInsertCoin();
//			}
		}else {
			System.out.println("결제 내역");
			System.out.println("잔돈 : " + change);
			System.out.println("이용해 주셔서 감사합니다.");
		}
	}
	
	/*
	 * 입력되는 동전 체크
	 */	
	public void checkInsertCoin() {		
		System.out.println("동전을 투입해주세요.");
		int coin = user.insertCoin();
		if(coin == 100 || coin == 500) {
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			//메뉴 선택 최소 금액 체크
			if(totalCoin < 200) { //조건을 반대로 바꾸려면 (!(totalCoin < 200))으로 하면 됨
				System.out.println("최소 주문 금액은 200원 입니다.");
				checkInsertCoin();
			}else {
				//메뉴 선택 여부 체크
				System.out.println("메뉴 선택(n), 동전 투입(아무키)> ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);
					showMenuList("주문가능메뉴");
					selectMenu();
				}else {
					checkInsertCoin();
				}
			}
		}else {
			System.out.println("동전은 100원, 500원만 사용 가능합니다. 동전 반환");
			checkInsertCoin();
		}		
	}
	/*
	 * 총 투입금액에 맞춘 메뉴 출력
	 */
	public void showMenuList(String msg) {	
		System.out.println("******************************************");
		System.out.println(title + " Coffee Machine");
		System.out.println("******************************************");
		System.out.println("\t" + msg);
		for(int i=0; i<orderCount; i++) {
			Menu menu = orderMenuList[i];
			System.out.print(menu.getNo() + ". ");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n"); 
		}
		System.out.println("******************************************");
	}
	
	
	/*
	 * 전체 메뉴 출력
	 */
	public void showMenuList() {
		System.out.println("******************************************");
		System.out.println(title + " Coffee Machine");
		System.out.println("******************************************");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ". ");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n"); 
			//String.format("%,d", menu.price) 숫자를 가격표시로 바꾸는 코드
		}
		System.out.println("******************************************");
	}	
	
	/*
	 * order 리스트 생성
	 */
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[menuList.length];
		
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {		            
				orderMenuList[orderCount] = menu;
				orderCount++;
			}			
		}
		
//		일반적인 for문의 경우		
//		for(int i=0; i<menuList.length; i++) {            
//			Menu menu = menuList[i]; //menuList의 배열을 하나씩 가져옴
//			if(menu.getPrice() <= totalCoin) {
//				//menuList의 price가 totalCoin보다 작거나 같은 배열을 가져온다.
//				orderMenuList[i] = menu;
//				//가져온 값을 orderMenuList의 배열에 넣는다.
//			}
//		}				
		
	}
	
	
	/*
	 * 메뉴 리스트 생성
	 */
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i + 1;
            String name = nameList[i];
            int price = priceList[i];
            
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
			//또는 (근데 가독성을 위해 위에걸 추천)
			//Menu menu = new Menu((i+1), nameList[i], priceList[i]);
		}
		
	}
	
}//class - VendingMachine
