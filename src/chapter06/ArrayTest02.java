package chapter06;

public class ArrayTest02 {

	public static void main(String[] args) {
		// names 문자열 변수 선언 및 생성
		String[] names;
		String names2[];
		
		names = new String[3];
		names2 = new String[5];
		
		int[] scores = new int[10];
//		int scores2[] = new double[10]; //데이터 타입이 다를 경우 불가
		int scores2[] = new int[3];
		int scores3[] = { 10, 20, 30 };
		String names3[] = { "홍길동", "홍길순" };
		
		names[0] = "홍길동";
//		names = "이순신"; //names 배열이므로 단일 값을 지정할 수 없다.
		
		//names 2번째 공간에 "이순신" 저장
		names[1] = "이순신";
		
		scores[0] = 100;
		scores[1] = 200;
		scores[2] = 300;
		
		System.out.println(names[0]);
		System.out.println(names2); //배열 번호 지정없이 출력하면 heap 저장소의 주소값이 나온다.
		System.out.println(names3);
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		
		System.out.println(names[1]);
	}

}
