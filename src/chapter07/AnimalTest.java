package chapter07;

public class AnimalTest {
	
	public static void main(String[] args) {
		System.out.println("AnimalTest 클래스 실행");

		//사자, 호랑이 객체 생성
		Animal lion = new Animal(); //Animal 함수 호출
		Animal tiger = new Animal(); //Animal 함수 호출
		Animal giraffe = new Animal();
		Animal elephant = new Animal();
		
		Animal2 lion2 = new Animal2("심바", 5);
		Animal2 tiger2 = new Animal2("호돌이");
		Animal2 elephant2 = new Animal2();
		//값이 아예 없어도 jvm이 기본생성자로 만들어주지만
		//오버로딩으로 같은 생성자가 있다면 만들어주지 않는다.
		
		Animal3 lion3 = new Animal3("심바");
		lion3.info();
		
		lion.name = "심바";
		lion.age = 5;

		tiger.name = "호돌이";
		tiger.age = 3;
		
		System.out.println("lion.name = "+lion.name);
		System.out.println("lion.age = "+lion.age);
		
		System.out.println("tiger.name = "+tiger.name);
		System.out.println("tiger.age = "+tiger.age);
		
		lion.sleep(); //메소드는 객체 생성 뒤에 실행해야한다.
		tiger.sleep();
		

		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = " + giraffe.name);
		System.out.println("elephant.name = " + elephant.name);
	
		//생성자 초기화
		System.out.println("-> 생성자 초기화");
		System.out.println("lion2.name = " + lion2.name);
		System.out.println("lion2.age = " + lion2.age);
		
		System.out.println("tiger2.name = " + tiger2.name);
		System.out.println("tiger2.age = " + tiger2.age);
		
		System.out.println("elephant2.age = " + elephant2.name);
		//elephant는 객체만 생성된 것
	}

}
