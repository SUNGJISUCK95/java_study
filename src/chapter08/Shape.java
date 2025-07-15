package chapter08;

public class Shape {
	String color;
	
	protected Shape(String color) { //protected는 상속받은 애들(자식)만 사용이 가능하다
		this.color = color;
	}
}
