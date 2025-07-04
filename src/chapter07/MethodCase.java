package chapter07;

public class MethodCase {
	//Field
	
	//Constructor
	public MethodCase() {
		System.out.println("MethodCase 객체 생성~");
	}
	//Method
	
	//리턴타입x, 매개변수x
	public void method1() {
		System.out.println("method1 --> 리턴타입 x, 매개변수 x");
	}
	
	//리턴타입o, 매개변수x
	public int method2() {
		int num1 = 10;
		int num2 = 20;
		return num1+num2;
	}
	
	//리턴타입x, 매개변수o
	//매개변수를 타입이나 개수를 다르게 주어 같은 메소드명 이여도 사용이 가능하다.
	//이것을 '메소드 오버로딩(Over loading)'이라고 한다.
	public void method3(int num1, int num2) {
		System.out.println("method3 --> " + (num1+num2));
	}

	public void method3(String name) {
		System.out.println("method3 --> " + name);
	}
	
	//리턴타입o, 매개변수o
	public int method4(int num1, int num2) {
		return num1 + num2;
	}

	public String method4(String name) {
		return name;
	}
	
	//main method
	public static void main(String[] args) {
		MethodCase mc = new MethodCase();
		mc.method1();
		int sum = mc.method2(); //여러번 사용 시 변수에 적용 후 사용
		System.out.println("method2 --> " + sum);
		
		mc.method3(10,20);
		mc.method3("홍길동");
		
		System.out.println(mc.method4(10,20));
		System.out.println(mc.method4("홍길동"));
	}
	
	
}
