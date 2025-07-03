package chapter07;

public class AnimalTest {
	
	public static void main(String[] args) {
		System.out.println("AnimalTest 클래스 실행");

		//사자, 호랑이 객체 생성
		Animal lion = new Animal(); //Animal 함수 호출
		Animal tiger = new Animal(); //Animal 함수 호출
		Animal giraffe = new Animal();
		Animal elephant = new Animal();
		
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
	}

}
