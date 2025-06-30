package chapter06;

import java.util.Scanner;

/*
 * 기본형 데이터와 참조형 데이터의 저장구조를 정리
 */
public class ReferenceDataCheckTest {

	public static void main(String[] args) {
		//기본형
		int a = 10;
		int b = 10;
		String str1 = "홍길동";
		String str2 = "홍길동";
		
		//call by value 형태로 값을 비교
		System.out.println("a == b : " + (a == b)); 
		System.out.println("str1 == str2 : " + (str1 == str2));
		
		//참조형
		String strObj1 = new String("홍길동");
		String strObj2 = new String("홍길동");
		
		System.out.println(System.identityHashCode(strObj1)); //더 자세한 형태로 heap 주소값 hash로 출력
		System.out.println(System.identityHashCode(strObj2));
		System.out.println("strObj1.equals(strObj2) : " + (strObj1.equals(strObj2))); 
		//서로 다른 heap 주소값을 가진 데이터를 데이터만 보고 동일한지 비교

		//
		strObj1 = str1; 
		//str1은 stack에 위치한 값이고 strObj1은 heap에 위치한 값이지만,
		//String 타입만 한정으로 내부에서 자동으로 heap에 str1의 문자열을 등록하여 strObj1에 주소값을 준다.
		System.out.println(strObj1);
		System.out.println(System.identityHashCode(strObj1));
		
		// Scanner 객첼ㄹ 이용하여 문자열 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열 입력 > ");
		String sdata = scan.next();
		
		System.out.println(sdata);
		System.out.println("sdata == str1 : " + (sdata == str1)); //Scanner로 입력한 문자열은 heap에 저장되므로 str1은 기본값이라 다름
		System.out.println("sdata.eqauls(str1) : " + (sdata.equals(str1))); //하지만 equals로 값만 비교하면 같음
	}

}
