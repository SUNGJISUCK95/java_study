package chapter07;

public class ArithmeticTest {

	public static void main(String[] args) {
		Arithmetic arithmetic = new Arithmetic();
		ArithmeticOverloading arithmetic_ol = new ArithmeticOverloading();
		
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(10, 20));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(3.14, 1.5));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("100", "200"));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(1,2,3,4,5,6,7,8,9));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("1","2","3","4"));
		
		System.out.println("----------------------");
		int add = arithmetic.add(10.7, 20.8);
		int add2 = arithmetic.add2(10, 20);
		double add3 = arithmetic.add3(3.14, 10);
		int add4 = arithmetic.add4(10, 20);
		int add5 = arithmetic.add5(10, 20);
		
		System.out.println("add = " + add);
		System.out.println("add2 = " + add2);
		System.out.println("add3 = " + add3);
		System.out.println("add4 = " + add4);
		System.out.println("add5 = " + add5);
	}

}
