package chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("홍길동");
		list2.add(String.valueOf(123)); //숫자 123을 String 타입으로 바꿔서 들어갈 수 있다.
		list2.set(0, "이순신");
		list2.add(1, "김유신");
		list2.remove(2);
		
		for(String str : list2) {
			System.out.println(str);
		}
		
		System.out.println(list.size()); //채워진 공간수 만큼
		list.add(100);
		list.add(new String("홍길동"));
		list.add(123.456);
		list.add(new Scanner(System.in)); //채워진 공간수 만큼
		System.out.println(list.size());
		System.out.println(list.get(0)); //int 타입
		System.out.println(list.get(1)); //String 타입
		System.out.println(list.get(3)); //객체 타입
	}

}
