package drink_Interface;

//import commons.Menu;

public class Order { //메뉴를 가지고 있는 클래스
	//Field
	Menu orderMenu; //메뉴의 주소를 받아 저장
	
	//Constructor
	public Order() {
		
	}
	public Order(Menu orderMenu) {  
		this.orderMenu = orderMenu;
		//주문받은 음료를 전역변수로 지정
	}
	
	//Method
	public void getInfo() {
		String price = String.format("%,d", orderMenu.getPrice());
		System.out.println("주문메뉴 : " + orderMenu.getName() + ", 결제 예정 금액 : " + price + "원");
	}
	
	public String getName() {
		return orderMenu.getName();
	}
	public int getTotal() {
		return orderMenu.getPrice();
	}
	
}
