package chapter06;

public class ArrayTest03 {

	public static void main(String[] args) {
		// 1에서 5까지의 데이터를 입력 후 순서대로 출력
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		int n4 = 4;
		int n5 = 5;
		
//		System.out.println(n1);
//		System.out.println(n2);
//		System.out.println(n3);
//		System.out.println(n4);
//		System.out.println(n5);
		
		//배열 객체 선언
		int n[] = new int[5]; 
		//또는 int n[] = {1,2,3,4,5};
		
//		n[0] = 1;
//		n[1] = 2;
//		n[2] = 3;
//		n[3] = 4;
//		n[4] = 5;
		
//		System.out.println(n[0]);
//		System.out.println(n[1]);
//		System.out.println(n[2]);
//		System.out.println(n[3]);
//		System.out.println(n[4]);
		
		//데이터 저장 및 출력
		for(int i=0; i<n.length; i++) { //배열의 전체 크기 : 변수명.length
			n[i] = i+1; //n[0] = 1;
			System.out.println(n[i]);
		}
		
	}

}
