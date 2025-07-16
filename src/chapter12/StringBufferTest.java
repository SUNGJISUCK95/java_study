package chapter12;

public class StringBufferTest {

	public static void main(String[] args) {
		String str = "홍길동";
		str = str + "은 자바를";
		str = str + " 열심히 공부한다.";
		
		System.out.println(str);

		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());
		
		//append로 하면 새로 stack에 영역을 생성하지않고 생성된 stack 자리에 그대로 더해서 생성된다.
		sb.append("홍길동");
		sb.append("은 자바를");
		sb.append(" 열심히 공부한다.");
		System.out.println(sb.capacity()); //문자열 길이
		System.out.println(sb); 
		System.out.println(sb.toString()); 
		
	}

}
