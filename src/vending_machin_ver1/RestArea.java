package vending_machin_ver1;

import commons.Menu;

public class RestArea {
	String name; // 휴게소 이름
	User user;
	VendingMachine machine;
	
	public RestArea() {
		this("만남의 광장");
	}
	public RestArea(String name) {
		this.name = name;
		user = new User("정국");
		welcome();
		machine = new VendingMachine("카누");				
	}
	
	public void welcome() {
		System.out.println("******************************************");
		System.out.println(name + " 휴게소에 오신것을 환영합니다.");
		System.out.println("******************************************");
	}
}
