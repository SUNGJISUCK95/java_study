package chapter11;

public class ExceptionTest3 {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = null;
		ExceptionObject eo = null;
//		eo = new ExceptionObject(); //생성자로 주소값 가져옴
//		eo.name = "홍길동"; //직접 지정
		
		//타입 없었으면 NullPointerException이 떳겠지만, String 타입이 있어서 비교가능
		if(name1.equals(name2)) { //동일 비교
			System.out.println("동일");
		} else {
			System.out.println("다름");
		}
		
		try {
			if(name1.equals(eo.name)) { //동일 비교
//				Exception in thread "main" java.lang.NullPointerException: Cannot read field "name" because "eo" is null
//				at java_study/chapter11.ExceptionTest3.main(ExceptionTest3.java:17)
				System.out.println("동일");
			} else {
				System.out.println("다름");
			}
		} catch(NullPointerException ne) { 
			//NullPointerException은 해결 안하면 다음 코드도 에러나서 무조건 해결해야 한다. 
			System.out.println("주소값 없음");
			ne.printStackTrace();
		}
	}

}
