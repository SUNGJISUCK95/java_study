package chapter12;

public class WrapperTest {

	public static void main(String[] args) {
		int num1 = 100;
		Integer num2 = new Integer(num1); // -로 취소선이 나오는 메소드는 자주 사용되지 않거나, 삭제 예정일 경우 표시된다.
		Integer num3 = Integer.valueOf(num1); // Integer보다 Integer.valueOf()를 사용하도록 권장
		int num4 =  Integer.parseInt("123");
		double dnum = Double.valueOf("123.60");
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(dnum);
	}

}
