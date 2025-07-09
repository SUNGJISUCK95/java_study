package vending_machin_ver2;

public class RestArea {
	//Field
	String name; //휴게소명
	User user;
	VendingMachine machine;
	
	//Constructor
	public RestArea() {
		this("만남의 광장");
	}
	
	public RestArea(String title) {
		this.name = title; //휴게소명 지정
		user = new User("홍길동"); //사용자명 지정
		welcome(); //휴게소 입장 출력
		machine = new VendingMachine("이디야",user);//
		
	}
	
	//Method
	public void welcome() {
		System.out.println("******************************************");
		System.out.println(name + " 휴게소에 오신것을 환영합니다.");
		System.out.println("******************************************");
	}
}
