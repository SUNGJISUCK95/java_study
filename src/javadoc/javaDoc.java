package javadoc;

//  한 행 주석
/*
 *  여러 행 주석
 */
/**
 *  이게 javaDoc
 *  JavaDoc 문서를 생성하는 클래스입니다. (설명서라고 생각하고 존댓말로만 사용)
 */
public class javaDoc {
	private String name;
	private int age;
	
	/**
	 * 기본 생성자
	 */
	public javaDoc() {
		
	}
	
	/**
	 * 문자열 타입의 name 파라미터를 받아 객체를 생성합니다.
	 * @param name 이름
	 */
	public javaDoc(String name) {
		this.name = name;
	}
	
	/**
	 * 문자열 타입의 name, 정수형 타입의 age 파라미터를 받아 객체를 생성합니다.
	 * @param name 이름
	 * @param age 나이
	 */
	public javaDoc(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 문자열 타입의 이름을 반환합니다.
	 * @return name 이름 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 문자열 타입의 이름을 받아 멤버변수 name을 초기화 합니다.
	 * @param name 이름 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 정수 타입의 나이를 반환합니다.
	 * @return age 나이
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 정수 타입의 나이를 받아 멤버변수 age을 초기화 합니다.
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
