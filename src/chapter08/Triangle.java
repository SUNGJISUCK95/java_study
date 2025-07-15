package chapter08;

public class Triangle extends Shape implements ShapeInterface{
	String color;
	int width;
	int height;
	
	public Triangle(String color, int width, int hright) {
//		this.color = color;
		super(color);
		this.width = width;
		this.height = height;
	}
	
//	public Triangle(int width, int height) {
//		this.width = width;
//		this.height = height;
//	}
	
	@Override
	public void draw() {
		System.out.println(color + " 삼각형");
	}
	
	@Override
	public double getArea() {
		return (width * height)/2;
	}
}
