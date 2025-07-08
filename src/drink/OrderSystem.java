package drink;

import java.util.Scanner;
//import commons.Menu;

public class OrderSystem {
	//Field
	Scanner scan = new Scanner(System.in);
	String[] names = {"☕ 아메리카노","🍵 바닐라 라떼","🥤 딸기 쉐이크"};
	int[] price = {2800,3500,4000};
	Menu[] menuList = new Menu[names.length]; //메뉴들을 저장하는 메뉴 리스트
	String title;
	Order order;
	Payment payment;
	
	//Constructor
	public OrderSystem() {
		this("Mega");
	}
	public OrderSystem(String title) {
		this.title = title;
		init();	//맨처음 실행	
	}
	
	//Method	
	public void init() {
		payment = new Payment();
		createMenuList(); //순차적으로 실행 1	
		showMenu(); // 2
		selectMenu(); // 3
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu(){
		System.out.println("메뉴 선택(숫자)>");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			if(1 <= menu && menu <= 3) {
				//번호에 맞는 메뉴를 메뉴리스트에서 검색한다.
				//검색한 메뉴를 Order생성자에 매개변수로 입력
				placeOrder(menu);
			}else {
				System.out.println("메뉴 준비중");
			}
		}else {
			System.out.println("입력값이 올바르지 않습니다. 다시 입력해 주세요.");
			scan.next(); //버퍼에 입력된 잘못된 입력값을 없애기 위해 작성
			selectMenu();
			
		}
	}
	
	/*
	 * 주문
	 */
	public void placeOrder(int menu) {
		//번호에 맞는 메뉴를 메뉴리스트에서 검색한다. 검색한 메뉴를 Order생성자에 매개변수로 입력
		order = new Order(searchMenu(menu));
		if(order.orderMenu != null) order.getInfo();
		System.out.println("주문 완료");
		
		processPayment();
	}
	
	/*
	 * 결제
	 */
	public void processPayment() {
		System.out.println("결제 금액(숫자)>");
		if(scan.hasNextInt()) {
			payment.setAmount(scan.nextInt());
			System.out.println("총 입금금액 : " + String.format("%,d",payment.getAmount()) + "원");
			if(payment.getPatment(order.orderMenu.price)) {
				//결제 완료
				System.out.println("결제 완료 \n잔돈 : " + String.format("%,d",payment.getChange()));
				showMenu();
				selectMenu();
			}else {
				//금액 부족
				System.out.println("금액이 부족합니다. 다시 입력해주세요.");
				processPayment();
			}
		}else {
			System.out.println("입력값이 올바르지 않습니다. 다시 입력해 주세요.");
			scan.next(); //버퍼에 입력된 잘못된 입력값을 없애기 위해 작성
			processPayment();			
		}
	}
	
	public Menu searchMenu(int menuNo) {
		Menu menu = null;
		
		for(Menu checkMenu : menuList) {
			if(checkMenu.no == menuNo) {
				menu = checkMenu;
				break;
			}
		}
		
		return menu;
	}
	
	public void createMenuList() {
		for(int i=0; i<names.length; i++) {
			Menu menu = new Menu((i+1), names[i], price[i]);
			//각각 0번 배열부터 값들을 menu에 지정
			menuList[i] = menu;
			//모인 값들을 menuList 배열에 저장
		}
	}
	
	public void showMenu() {
		System.out.println("******************************************");
		System.out.println(title + " Coffee Menu");
		System.out.println("******************************************");
		for(Menu menu : menuList) {
			System.out.print(menu.no + ". ");
			System.out.print(menu.name + "\t");
			System.out.print(String.format("%,d", menu.price) + "원\n"); 
			//String.format("%,d", menu.price) 숫자를 가격표시로 바꾸는 코드
		}
		System.out.println("******************************************");	
	}
	
}//class

