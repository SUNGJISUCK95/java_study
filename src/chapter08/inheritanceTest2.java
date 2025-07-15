package chapter08;

public class inheritanceTest2 {

	public static void main(String[] args) {
		Circle c1 = new Circle("빨강",15); 
		Circle c2 = new Circle("파랑",18); 
		Rectangle r1 = new Rectangle("노랑",6,17);
		Rectangle r2 = new Rectangle("초록",6,17);
		Triangle t1 = new Triangle("주황",5,10);

		
//		Circle cArea = new Circle(15);
//		Rectangle rArea = new Rectangle(6, 17);
//		Triangle tArea = new Triangle(5, 10);
		
		
		//출력되는 모습이 다른것 그게 오버라이딩(Overriding)
		c1.draw();
		c2.draw();
		r1.draw();
		r2.draw();
		t1.draw();
		
		
		
//		System.out.println(cArea.getArea());
//		System.out.println(rArea.getArea());
//		System.out.println(tArea.getArea());
	}
}
