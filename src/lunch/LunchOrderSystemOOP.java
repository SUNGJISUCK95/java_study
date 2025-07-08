package lunch;

import java.util.Scanner;

public class LunchOrderSystemOOP {
	//Field
	String title;
	Scanner scan; //field는 호출
	LunchOrderMenuManager menuManager;
	String[] lunchMenuNames = {"햄버거(🍔)","피자요(🍕)","라멘요(🍜)","샐러드(🥗)"};
	//선언 + 값할당이 같이 일어나야함
	int[] lunchMenuPrice = {100,200,300,400};
	//값이 들어있는 배열은 초기화가 안됨
	LunchMenu[] lunchMenuList; 	//주문할 메뉴 : LunchMenu
	LunchOrderItem[] orderItemList;
	//값이 없는 배열은 초기화가 가능
	LunchPaymentItem paymentItem;
	int orderCount = 0;
	int amount = 0; //결제금액-사용자 입력
	int change = 0; //잔돈
	
	//Constructor(생성자)
	public LunchOrderSystemOOP() {
		scan = new Scanner(System.in); //생성자는 초기화
		menuManager = new LunchOrderMenuManager(this);
		//자신의 주소를 다른 파일로 옮길땐 this를 매개변수로 넣어준다.		
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu();
	}
	
	public LunchOrderSystemOOP(String title) {
		this.title = title; 
		//LunchOrderSystemOOPTest에 값 넣고
		//매개변수 지정해서 받아서 전역변수에 값 넣어서 사용
		scan = new Scanner(System.in); //생성자는 초기화
		menuManager = new LunchOrderMenuManager(this);
		lunchMenuList = new LunchMenu[4];
		orderItemList = new LunchOrderItem[4];
		
		menuManager.createLunchMenu();
		menuManager.showMainMenu();
	}
	
	//Method
	
	
	/*
	 * 주문아이템의 인덱스 검색
	 */
	public int searchOrderItemIdx(int lunchMenu) {
		int idx = -1;
		for(int i=0; i<orderCount; i++) {
			LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu) idx = i;
		}
		
		return idx;
	}	
	
	/*
	 * 주문 : order()
	 */
	public void order(int lunchMenu) {		
		//lunchMenuList의 메뉴 번호 확인
		for(LunchMenu menu : lunchMenuList) {
			if(menu.no == lunchMenu) {
				
				int idx = searchOrderItemIdx(lunchMenu);
				
				if(idx == -1) {
					orderItemList[orderCount] = new LunchOrderItem();
					
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;					
					orderCount++;
				} else {
					orderItemList[idx].qty += 1;	
				}
				break;
			}
		}
		
		System.out.println("=> 주문 완료!!"+orderCount);
		menuManager.showMainMenu();
	}
	
	/*
	 * 주문 내역 : orderList()
	 */
	public void orderList() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역 존재X, 음식을 주문해주세요");			
		} else {
			System.out.println("-----------------------------------------");
			System.out.println("\t음식 주문 내역");
			System.out.println("-----------------------------------------");
			System.out.println("번호\t메뉴명\t가격\t수량");
			System.out.println("-----------------------------------------");
			for(LunchOrderItem orderItem : orderItemList ) {
				if(orderItem != null ) {
					System.out.print(orderItem.no + "\t");
					System.out.print(orderItem.name + "\t");
					System.out.print(orderItem.price + "\t");
					System.out.print(orderItem.qty + "\n");
				}
			}
			System.out.println("-----------------------------------------");
		}
		menuManager.showMainMenu();
	}
	
	/*
	 * 결제 예정금액 산출
	 */
	public int totalPayment() {
		int sum = 0;
		for(LunchOrderItem orderItem : orderItemList ) {
			if(orderItem != null) {
				sum += orderItem.price * orderItem.qty;
			}
		}		
		return sum;
	}
	
	/*
	 * 결제 : payment()
	 */
	public void payment() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역 존재X, 음식을 주문해주세요");			
		} else {	
			int total = totalPayment();
			System.out.println("=> 결제 예정 금액 : "+ total);
			System.out.print("결제할 요금 입력(숫자)> ");
			if(scan.hasNextInt()) {
				amount += scan.nextInt();
				System.out.println("=> 총 입력 금액 : " + amount);				
				
				if(amount >= total) {								
					change = amount - total;
					
					paymentItem = new LunchPaymentItem();
					paymentItem.name = orderItemList[0].name + "등";
					paymentItem.totalPayment = total;
					paymentItem.amount = amount;
					paymentItem.change = change;	
					System.out.println("=> 결제 성공!!");	
					
					//주문리스트 초기화
//					orderItemListInit();
				} else {
					System.out.println("=> 요금이 부족합니다. 다시 입력해 주세요");
					payment();
				}			
				
			} else {
				System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
				scan.next();
			}//if
		}
		menuManager.showMainMenu();
	}
	
	/*
	 * 결제 내역 : paymentList()
	 */
	public void paymentList() {
		if(paymentItem == null) {
			System.out.println("=> 결제 내역X, 주문을 진행해주세요");
		} else {
			System.out.println("-----------------------------------------");
			System.out.println("\t결제 내역");
			System.out.println("-----------------------------------------");
			System.out.println("주문명\t결제금액\t총입금액\t잔돈");
			System.out.println("-----------------------------------------");
			System.out.print(paymentItem.name + "\t");
			System.out.print(paymentItem.totalPayment + "\t");
			System.out.print(paymentItem.amount + "\t");
			System.out.print(paymentItem.change + "\n");
			System.out.println("-----------------------------------------");
		}
		menuManager.showMainMenu();
	}
	
}//class