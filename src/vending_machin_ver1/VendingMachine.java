package vending_machin_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 우유"};
	int[] priceList = {300,400,300,200};
	Menu[] menuList;
	String title;
	
	public VendingMachine() {
		this("막심");
	}
	public VendingMachine(String title) {
		this.title = title;
		createMenuList();
		showMenuList();
	}
	
	/*
	 * 메뉴 출력
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
	 * 메뉴 리스트 생성
	 */
	public void createMenuList() {
		menuList = new Menu[nameList.length];
//		System.out.println("메뉴 선택> ");
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
