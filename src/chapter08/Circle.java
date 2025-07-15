package chapter08;

public class Circle extends Shape implements ShapeInterface{
//	String color;
	int radius;
	public static final double P1 = 3.14;
	
	public Circle(String color, int radius) {
		super(color);
//		this.color = color;
		this.radius = radius;
	}
	
//	public Circle(int radius) {
//		this.radius = radius;
//	}
	
	@Override
	public void draw() {
		System.out.println(color + " 원");
	}
	
	@Override
	public double getArea() {		
		return P1 * radius * radius;
	}
}
