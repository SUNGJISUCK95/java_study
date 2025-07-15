package chapter08;

//abstract 메소드를 하나라도 가지고 있으면 그 클래스는 abstract 클래스가 된다.
//abstract(추상) 클래스는 객체 생성이 불가능하다.
//추상클래스에서 필드, 생성자, 메소드를 사용하고 싶으면 static으로 get,set해서 사용해야한다.
abstract public class Client {
	public static String name;
	public static int age;
	
//	public Client() {
//		this("홍길동", 10);
//	}
//	
//	public Client(String name) {
//		this(name, 10);
//	}
//	
//	public Client(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
	

	//Method
	//body({})가 없는데 이런 메소드를 '추상(abstract)메소드'라고 한다.
	//오버라이드되는 메소드는 body 없이 이름만 선언됨
	//추상메소드는 abstract를 앞에 붙여햐 하며, 클래스도 abstract를 선언해야 한다.
	abstract public void printInfo(); //부모가 가진 printInfo() 메소드를 강제적으로 상속함

	abstract public void register();
	
	abstract public void payment();
}
