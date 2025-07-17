package chapter13;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 인터페이스
 */
public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> subjects = new HashMap<Integer, String>();
		
		//1. 데이터 저장 : C(Create)
		subjects.put(1, "java");
		subjects.put(2, "mysql");
		subjects.put(3, "html");
		
		//2. 데이터 출력 : R(Read)
//		subjects.forEach(System.out::println); 
		//클래스 참조 형식의 람다코드는 사용 X
		//타입이 두개가 들어와서 출력 에러
		
		System.out.println("-----데이터 출력--------");
		
		subjects.forEach((key, value) -> { //타입을 두가지 설정해줌
			System.out.println(key + "," + value);
		}); 
		
		System.out.println("-----데이터 수정--------");
		
		//3. 데이터 수정 : U(Update)
		//mysql --> oracle
		if(subjects.containsKey(2)) {
			subjects.put(2, "oracle");
		}
		//또는
//		if(subjects.containsKey(2)) {
//			subjects.replace(2, "oracle");
//		}
		
		subjects.forEach((key, value) -> { //타입을 두가지 설정해줌
			System.out.println(key + "," + value);
		}); 
		
		System.out.println("-----데이터 삭제--------");
		
		//4. 데이터 삭제 : D(Delete)
		//oracle 삭제
		subjects.remove(2);
		
		subjects.forEach((key, value) -> { //타입을 두가지 설정해줌
			System.out.println(key + "," + value);
		}); 
		
		System.out.println("-----전체 삭제--------");
		
		subjects.clear(); //전체 삭제
		
		subjects.forEach((key, value) -> { //타입을 두가지 설정해줌
			System.out.println(key + "," + value);
		}); 
	}

}
