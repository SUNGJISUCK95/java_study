package chapter13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List 인터페이스
 */
public class ListTest {

	public static void main(String[] args) {
		//일반적으로 <>(제너릭)을 통해 데이터타입을 정의한 후 사용		
		List<Integer> list1 = new ArrayList<Integer>(); //타입은 클래스로만 지정가능해서 int X Integer O
		List<String> list2 = new LinkedList<String>();
		List<Double> list3 = new Vector<Double>();
		
		int n = 100; 
		list1.add(n);
		
		//1. 데이터 저장 : C(Create)
		list1.add(100);
		list1.add(200);
		list2.add("100");
		list2.add("홍길동");
		list3.add(1.23);
		list3.add(100.0);
		
		//2. 데이터 출력 : R(Read)
		for(int i=0; i<list1.size(); i++) { 
			//size()는 count변수와 같은 기능 
			//list1.add(100); list1.add(200); 를 했으므로 size의 값은 2
			
			System.out.println(list1.get(i)); 
		}
		
		for(String str : list2) { //list2의 타입은 String 이므로 변수도 String 타입
			
			System.out.println(str);
		}
		
		String[] slist = new String[5];
//		slist.forEach(); //String은 Iterable을 상속받지 않았지 때문에 forEach가 사용 안된다.
		//java와 javascript를 다르게 봐야한다.
		
		//forEach의 매개변수는 람다식 메소드 호출 방식을 갖는다.
		//() -> {}
		list3.forEach((dnum) -> { //List는 Iterable을 상속 받았기 때문에 사용가능하다.
			System.out.println(dnum);
		});
		
		//↑ 더 간략화 하면 ↓
//		list3.forEach(dnum -> System.out.println(dnum));
		
		//↑ 더 간략화 하면 ↓
//		list3.forEach(클래스타입::매소드명);
		list3.forEach(System.out::println);
		
		//3. 데이터 업데이트 : U(Update)
		list1.set(0, 1000); //list1.add(100); => 1000으로 값 변경
		list2.set(0, "이순신"); //list2.add("100"); => 이순신으로 문자열 변경
		list3.set(0, 999.987); //list3.add(1.23); => 999.987로 변경
		
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		list3.forEach(System.out::println);
		
		//4. 데이터 삭제 : D(Delete)
		list1.remove(0); //list1.add(100); => 0번지 배열이 여서 삭제
		list2.remove(0); //list2.add("100"); => 0번지 배열이 여서 삭제
		list3.remove(0); //list3.add(1.23); => 0번지 배열이 여서 삭제
		
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		list3.forEach(System.out::println);
		
		//** 데이터 삭제시 인덱스 중복으로 인한 내부 에러 발생함
		//Iterable 인터페이스를 통한 삭제를 권장
		List<String> list4 = new ArrayList<String>();
		list4.add("java");
		list4.add("mysql");
		list4.add("html");
		list4.add("css");
		list4.add("java"); //중복 데이터 추가 가능
		list4.add("css");
		
		list4.forEach(System.out::println);
		
		System.out.println("-----------------------");
		
		Iterator<String> ie = list4.iterator();
		while(ie.hasNext()) { //데이터를 삭제하는 기능
			String element = ie.next();
//			System.out.println(element);
			if(element.equals("html")) { //list4안에 html이 있다면 
				ie.remove(); //html을 지운다.
				//Iterator는 배열의 데이터를 삭제하면 기존에 있던 데이터구조를 전부 삭제하고 
				//삭제하려던 데이터를 삭제 후 삭제된 자리는 땡겨서 새로 정렬하여 넣어준다.
			}
		}
		
		list4.forEach(System.out::println);
	}

}
