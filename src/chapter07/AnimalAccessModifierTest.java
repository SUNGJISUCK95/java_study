package chapter07;

import commons.Animal; //commns에 있는 Animal 가져옴
import java.util.Calendar;

public class AnimalAccessModifierTest {

	public static void main(String[] args) {
//		Calendar c = new Calendar(); 
		// 상속관계가 없으므로 객체생성 불가
		Calendar c = Calendar.getInstance(); 
		// 생성된 객체의 인스턴스 주소를 가져옴 
		// 이것을 싱글톤 패턴이라고 부른다. 
		System.out.println(c.getTime());
		
		AnimalAccessModifier aam = new AnimalAccessModifier("호순이", 7);
		//생성자 호출 (AnimalAccessModifier에서 기본생성자는 생성자가 아무것도 없으면 호출 가능)
		Animal comDog = new Animal();
		
		//static 변수, static 메소드 호출
		AnimalAccessModifier.sname = "스태틱";
		AnimalAccessModifier.sage = 10;
		AnimalAccessModifier.getInfo3();
		//static은 aam. 처럼 변수설정해서 쓰기 보단 위처럼 바로 호출해서 쓴다.
		aam.sname = "스태틱";
		aam.sage = 12;
		aam.getInfo3();
		
		//final 변수 테스트
		//final 키워드 변수는 외부에서 값을 변경할 수 없다.
//		aam.fname = "홍길순";
//		aam.fage = 2;
		
		//상수 호출
		int start = AnimalAccessModifier.START;
		int con = AnimalAccessModifier.CONTINUE;
		int end = AnimalAccessModifier.END;
		
		comDog.setName("호순이");
		comDog.setAge(10);
		
//		comDog.name = "삐삐"; 
//		comDog.age = 3;
//		//다른 패키지이고 public으로 모두 공유 안해서 사용 불가능
//		//패키지가 다르므로 접근 불가
		
		comDog.name2 = "삐삐"; //다른 패키지이고 public으로 모두 공유해서 사용가능
		comDog.age2 = 3;
		
		aam.name = "심바"; 
		aam.age = 5;
		//AnimalAccessModifier에서 name,age에 public 접근제어자를 줘서 aam.으로 접근 가능
		
		aam.name2 = "홍길동"; 
		aam.age2 = 8;
		//protected는 같은 패키지에서 공유가 가능함
		//아무 접근제어자를 안쓰면 protected이가 ex) int age = protected int age
		
//		aam.name3 = "김유신"; 
//		aam.age3 = 15;
		//private는 본인이 위치한 클래스에서만 공유가 가능함
		//aam은 AnimalAccessModifier 클래스에서 존재함
		
		System.out.println("name = " + aam.name);
		System.out.println("age = " + aam.age);
		System.out.println("name3 = " + aam.getPname());
		System.out.println("age3 = " + aam.getPage());
		System.out.println("addr = " + comDog.getAddr());
		System.out.println("color = " + comDog.getColor());
		System.out.println("name = " + comDog.getName());
		System.out.println("age = " + comDog.getAge());
	}

}
