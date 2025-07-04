package chapter07;

/*
 * 두 개의 숫자를 입력받아 결과를 리턴하는 메소드를 포함
 * sub 메소드 기능은 첫번째 숫자가 큰 경우에만 빼기, 작은 경우 또는 같은 경우에는 0을 리턴
 */
public class Arithmetic {
	//Field
	
	//Constructor
	
	//Method
	public int add(double x, double y) {
		return (int)x + (int)y;
		//변수의 타입이 다르면 리턴값에서 명시적 형변환해서 리턴
	}
	
	public int add2(int x, int y) {
		int result = 0;
		
		if(x>y) {
			result = x-y;
		}
		
		return result;
		
	}
	
	public double add3(double x, int y) {
		return x * y;
	}
	
	public int add4(int x, int y) {
		return x / y;
	}
	
	public int add5(int x, int y) {
		return x % y;
	}
}
