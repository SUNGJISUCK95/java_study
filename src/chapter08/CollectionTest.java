package chapter08;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Collection의 클래스들이 인터페이스기반으로 설계 됨
 * 인터페이스 기반으로 객체 생성하는 것을 권장
 */
public class CollectionTest {

	public static void main(String[] args) {
		List<String> list2 = new Vector(); //Vector도 List를 상송하고 있기 때문에 사용가능
		List<String> list = new ArrayList<String>(); //<>는 제너릭(Generic)이라고 한다. //공간을 자동 생성해줘서 null이 뜰일이 없다.(기본 10개 시작)

		//ArrayList<String> list = new ArrayList<String>(); 가 아닌 List<String> list = new ArrayList<String>(); 로 함으로써
		//List<String> list = new Vector(); 로 자식부분만 바꾸면서 수정의 편의성이 높다.
		
		list.add("홍길동");
		
		System.out.println(list.get(0));
	}

}
