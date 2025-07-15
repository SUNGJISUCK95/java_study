package chapter08;

public class inheritanceTest {

	public static void main(String[] args) {
//		Client c1 = new Client(); //추상클래스는 객체 생성이 안된다.
		Person p1 = new Person();
		Animal a1 = new Animal();
		Person p2 = new Person("김유신","종로구","010-9876-5432",12);
		Animal dog = new Animal("명수", 5, p1);
		Animal cat = new Animal("야옹이", 6, p2);

// 출력 결과
//		Client 생성자 호출
		
//		Client 생성자 호출 (부모)
//		Person 생성자 호출 (자식)
		
//		Client 생성자 호출 (부모)
//		Animal 생성자 호출 (자식)
		
//		c1.name = "홀길동";
//		p1.name = "홍길동"; 
		// 부모인 Client의 name 변수 사용하고 싶을땐? 
		// 자식만 사용할 수 있다. 부모 호출 x 
		// 자식이 가지고 있지않을 경우 부모것 호출 ex) Person이 name 필드가 없으면 Client의 name 필드 사용
//		a1.name = "예삐";

//		System.out.println("c1.name ==> " + c1.name);
		System.out.println("p1.name ==> " + p1.name);
		System.out.println("a1.name ==> " + a1.name);
		System.out.println("p2.name ==> " + p2.name); 
		//자식, 부모 같은 필드값을 가지면 p2.은 Person을 기준으로 호출이므로 부모의 name값을 가져오지 못한다.
		//결론: 필드값 중복 x
		
//		c1.name ==> 홀길동
//		p1.name ==> 홍길동
//		a1.name ==> 예삐
		
//		c1.printInfo();
		p1.printInfo();
//		a1.printInfo();
		p2.printInfo();
		dog.printInfo();
		cat.printInfo();
		//Client가 부모클래스 이므로 자식 클래스가 printInfo() 메서드를 사용할 수 있다.
		//부모쪽에 메서드를 만들어 사용하는게 효율적이다.
		
		dog.sound();
		cat.sound();
		
		p1.register();
		p2.register();
		p1.payment();
		p2.payment();
		dog.register();
		cat.register();
	}
}
