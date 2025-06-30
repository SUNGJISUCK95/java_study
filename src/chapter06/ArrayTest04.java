package chapter06;

import java.util.Scanner;

public class ArrayTest04 {

	public static void main(String[] args) {
		// 배열 객체 생성 후 크기 확인 : 기본형 데이터를 저장하는 객체 생성
		int[] numberList = new int[5]; 
		//numberList는 참조 변수 , 배열 안의 데이터는 기본형이다.
		String[] nameList = { "홍길동", "이순신", "김유신" };
		boolean[] flagList = new boolean[2];
				
		System.out.println(numberList.length);
		System.out.println(nameList.length);
		System.out.println(flagList.length);
		
		// 배열 객체 생성 후 크기 확인 : 참조 데이터를 저장하는 객체 생성
		Scanner[] scanList = new Scanner[3];
		//Scanner 클래스의 객체를 3개 저장하겠다.
		
		//scanList 0번지에 Scanner 객체 생성후 주소 저장
		scanList[0] = new Scanner(System.in);
		scanList[1] = new Scanner(System.in);
		scanList[2] = new Scanner(System.in);
		
		System.out.println(scanList.length);
		System.out.println(scanList[0]);
		System.out.println(scanList[1]);
		System.out.println(scanList[2]);	
		
		System.out.println(scanList[0].hashCode());
		//배열안의 객체 주소값을 해쉬코드로 출력
		System.out.println(scanList[1].hashCode());
		System.out.println(scanList[2].hashCode());
		
		scanList[0] = scanList[2]; 
		//scanList의 0번지 값을 scanList 2번지 주소로 설정
		//이런 식으로 heap 영역의 주소값에 또 다른 주소값을 넣고 넣고 방식이 가능
	
		System.out.println(scanList[0].hashCode());
		System.out.println(scanList[2].hashCode());
		//0번지의 해쉬코드가 2번지랑 같은 것을 확인
		
		int[] nlist = new int[3];
		nlist[0] = 10;
		nlist[1] = 20;
		nlist[2] = 30;
		
		nlist[0] = nlist[2];
		System.out.println(nlist[0]);
		System.out.println(nlist[1]);
		System.out.println(nlist[2]);
//		System.out.println(nlist[0].hashCode());
		//nlist안에 있는 값은 기본값이므로 주소값이 아니여서 hashCode 출력 불가
	}

}
