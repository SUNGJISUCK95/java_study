package chapter07;

/*
 * 생성자 오버로딩, this() 메소드
 */
public class Animal3 {
	//Field
	int age;	
	String name;
	String addr;
	
	//Constructor
	public Animal3() {
		this("홍길동", 5, "강남구");	
		//this.name = "홍길동"; 
		//따로 전역변수에 선언해도 위에 이미 오버로딩으로 넘어갔으므로 실행안함
	
	}
	public Animal3(String name) {
//		this.name = name;
//		this.age = 5;
//		this.addr = "강남구";
		
		//위 처럼 직접 지정도 가능하지만 오버로딩 메소드에 값을 넣고 this로 호출가능
		this(name, 5, "강남구");
	}
	public Animal3(String name, int age) {
//		this.name = name;
//		this.age = age;
		
		this(name, age, "강남구");
	}
	public Animal3(int age) {
//		this.age = age;
		
		this("홍길동", age, "강남구");
	}
	public Animal3(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	//Method
	public void info() {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("addr = " + addr);
		
	}
	
}
