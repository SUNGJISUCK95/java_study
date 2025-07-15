package chapter08;

public class ObjectTypeCastingTest {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑", 1);
		Rectangle blueR  = new Rectangle("파랑", 1, 2);
		
		Shape s = new Circle("초록색", 2); //자동(묵시적) 형변환
		//전체적인 부분은 Circle에서 Shape 부분만 활성화됨 
		//Shape는 Circle의 부모 클래스이기 때문에 Circle을 사용가능
//		Rectangle t = new Circle("초록색", 2);
		//Rectangle은 Circle의 부모가 아니므로 Circle 사용 불가능 
		
		//※ 부모의 내용을 받아서 자식이 확장되므로 (부모 < 자식) 이다.
		
		Circle cs = (Circle)s; //강제(명시적) 형변환
		//Shape는 Circle의 부모이므로 Circle로 형변환이 가능하다.
		
		Shape s2 = new Shape("빨강");
//		Circle cs2 = (Circle)s2; //s2에 Circle의 내용이 아예 없기 때문에 형변환 불가
		
//		Rectangle r = (Rectangle)s; //s는 Rectangle 내용이 아예 없기 때문에 형변혼 불가

		//※ 부모의 모습으로 자식의 내용을 넣어줘야 형변환 가능 ex) Shape s = new Circle("초록색", 2); -> Circle cs = (Circle)s;
		
		//인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장함
		//상속받은 인터페이스를 통한 객체 생성 : 인터페이스 기반 설계
		ShapeInterface si = new Circle("코랄", 1);
		ShapeInterface si2 = new Rectangle("퍼플", 2, 5);
		ShapeInterface si3 = new Triangle("오렌지", 3, 10);
//		   (추상 메소드)			  (상속받아 오버라이딩)          =>    이게 객체지향의 다형성
		
		//※ 부모와 자식을 만들고 부모는 자식들의 공통된 메소드를 뽑아내고 그걸 인터페이스로 활용
		//※ 권장 이유는 AIP에 이런형식이 많아서
		//인터뷰) 질문: 어떤식으로 형변환했는지? -> 답변: 인터페이스 형태로 객체생성을 진행하였다.
		
		si.draw(); 
		si2.draw(); 
		si3.draw(); 
		//자식인 Circle의 draw()가 호출됨
		//ShapeInterface draw() 함수가 있으므로 접근이 가능하다
		System.out.println(si.getArea());
		System.out.println(si2.getArea());
		System.out.println(si3.getArea());
		
		Circle cs3 = (Circle)si;
		Rectangle cs4 = (Rectangle)si2;
		Triangle cs5 = (Triangle)si3;
		cs3.draw();
		cs4.draw();
		cs5.draw();
		System.out.println(cs3.getArea());
		System.out.println(cs4.getArea());
		System.out.println(cs5.getArea());
		
		
		
		cs.draw();
//		cs2.draw();
		
		yellowC.draw();
		blueR.draw();
//		s.draw();
		//Shape 클래스는 draw() 메소드를 정의하지 않음
		//Shape에는 draw() 함수가 없으므로 접근이 불가능하다
		System.out.println(s.color);
	}

}
