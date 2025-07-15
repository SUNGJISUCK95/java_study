package chapter08;

public class Animal extends Client{
	String name;
	int age;
	Person owner;
	
	public Animal() {
		this("예삐", 3, null);
	}
	
	public Animal(String name, int age, Person owner) {
		this.name = name;
		this.age = age;
//		super(name, age);
		this.owner = owner;
	}
	
	//Method
	public void sound() {
		System.out.println(name + "짖는다");
		//필드에 name이 없지만 부모클래스가 name을 가지고 있어서 사용이 가능하다.
	}
	
	@Override
	public void register() {
		System.out.println(name + "의 주인인 " +owner.name + " 고객이 접수를 한다.");
	}
	
	@Override
	public void payment() {
		System.out.println("결제한다.");
	}
	
	//고객 정보 출력시 owner 정보 포함
	//상세한 정보 ex)주인의 이름,나이 작업은 자식클래스에서 해야한다.
	//오버라이딩(Overriding) : 부모 클래스를 상속받을때 똑같은 메소드를 무조건 상속받는 것 ex)체인점은 본점의 레시피를 그대로 물려받아 사용한다.
	//오버라이딩 장점 : 부모가 가진 메소드를 알면 자식의 메소드를 알지않아도 된다. 어짜피 부모꺼라서
	@Override
	public void printInfo() { //부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
		System.out.print("고객(Client)정보 --> " );
		System.out.print(name + ",");
		System.out.print(age + ",");
		System.out.print(owner.name + ",");
		System.out.println(owner.age);
	}
}
