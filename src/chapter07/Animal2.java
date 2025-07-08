package chapter07;

public class Animal2 {
	//Field : 전역변수(JVM이 알아서 값을 초기화해줌)
	String name;
	int age;
	
	//Constructor : 생성자는 오버로딩이 가능함 (리턴타입은 상관x, 매개변수의 타입이나 수가 달라야함)
	public Animal2() { //기본 생성자
		//생성자 호출 시 실행되는 내용 => new Animal() 코드 실행 시 실행됨
		System.out.println(name + "객체를 생성한다.");
	}
	
	public Animal2(String name) { //field의 name만 초기화 //매개변수 선언 시 field명과 같게 설정
		this.name = name; 
		//this.을 붙여줘야 전역변수 선언가능
		//이런 식으로 매개변수 값을 전역변수로 사용가능
		System.out.println(name + "객체를 생성한다.");
	}
	
	public Animal2(String name, int age) { //field의 name, age 초기화
		this.name = name; 
		this.age = age;
		System.out.println(name + "객체를 생성한다.");
	}

	//Method
	public void sleep() {
		System.out.println(name + "-> 잠을 잔다.");
	}
	
}
