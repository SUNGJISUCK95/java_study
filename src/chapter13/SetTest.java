package chapter13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 인터페이스
 */
public class SetTest {

	public static void main(String[] args) {
		Set<String> foods = new HashSet<String>();
		
		//1. 데이터 저장 : C(Create)
		foods.add("된장찌개");
		foods.add("김치찌개");
		foods.add("짜장면");
//		foods.add("짜장면"); //중복 데이터 저장 x
		
		//2. 데이터 출력 : R(Read)
		foods.forEach(System.out::println);
		
		//3. 데이터 수정 : U(Update)
		//짜장면 --> 짬봉
		if(foods.contains("짜장면")) { //foods에 짜장면이 있다면
			foods.remove("짜장면"); //짜장면 삭제
			foods.add("짬봉"); //짬봉 추가
			foods.forEach(System.out::println);
			//출력 순서를 지키고 싶다면 ArrayList를 사용해야 한다.
		}
		
		//4. 데이터 삭제 : D(Delete)
		//김치찌개 삭제
		
		//방법1
		if(foods.contains("김치찌개")) {
			foods.remove("김치찌개");
			foods.forEach(System.out::println);
		}
		
		//방법2
		Iterator<String> ie = foods.iterator(); //제너릭으로 타입을 제한하지 않으면 Object 타입으로 생성됨
		while(ie.hasNext()) {
			String food = ie.next(); //기본 타입이 Object이므로 인터페이스 <>(제너릭)에 String 타입을 넣어줘야 가능하다.
			//또는
//			String food2 = (String)ie.next(); //강제 형변환 타입 지정
			if(food.equals("김치찌개")) {
				ie.remove();
			}
		}
		
		foods.forEach(System.out::println);
	}

}
