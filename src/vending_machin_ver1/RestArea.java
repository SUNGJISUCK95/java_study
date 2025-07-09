package vending_machin_ver1;

import commons.Menu;

public class RestArea {
	String name; // 휴게소 이름
	User user;
	VendingMachine machine;
	
	public RestArea() {
		this("만남의 광장"); //생성자 호출 함수
	}
	public RestArea(String name) {
		this.name = name; //받은 파라미터의 값을 전역변수로 사용 //멤버변수 초기화 작업
		user = new User("정국");
		welcome();
		machine = new VendingMachine("카누",user);				
	}
	
	public void welcome() {
		System.out.println("******************************************");
		System.out.println(name + " 휴게소에 오신것을 환영합니다.");
		System.out.println("******************************************");
	}
}
