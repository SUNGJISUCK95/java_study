package chapter08;

public class Person extends Client{ //Client 먼저만들고 Person 만들고
	String name;
	String address;
	String phone;
	int age;	
	
	public Person() {
		this("이순신", "강남구", "010-1234-1234", 20);
	}
	
	public Person(String name, String address, String phone, int age) {
		//name, age 필드는 부모클래스에서 사용
//		super(name, age); //부모 클래스의 생성자를 호출하는 메소드 super() //항상 부모거 부터 만들고 자식거 순서로 만들어야한다.
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public void register() {
		System.out.println(name + " 고객이 접수를 한다.");
	}
	
	@Override
	public void payment() {
		System.out.println(name + " 고객이 결제한다.");
	}
	
	@Override //Override는 그저 명칭일뿐 기능은 없다. 직관성을 위해서 사용
	public void printInfo() { //부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
		//매개변수, 메소드명 이 부모클래스와 완전같아야함
		System.out.print("고객(Client)정보 --> " );
		System.out.print(name + ",");
		System.out.print(age + ",");
		System.out.print(address + ",");
		System.out.println(phone);
	}
	
//	public void printInfo(String name) { //부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
//		System.out.print("고객(Client)정보 --> " );
//		System.out.print(name + ",");
//		System.out.print(age + ",");
//		System.out.print(address + ",");
//		System.out.println(phone);
//	}
//	
//	public void printInfo2() { //부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
//		System.out.print("고객(Client)정보 --> " );
//		System.out.print(name + ",");
//		System.out.print(age + ",");
//		System.out.print(address + ",");
//		System.out.println(phone);
//	}
}
