package chapter07;

public class AnimalAccessModifier {
//접근제어자
//public이 없으면 chapter07에서만 사용가능
	
	//Field
	public String name;
	public int age;
	protected String name2;
	protected int age2;
	private String name3;
	private int age3;
	
	static String sname; //static 변수, 클래스 변수 라고 부른다.
	static int sage;
	
	final String fname = "홍길동"; //final 키워드 적용 -> 외부에서 값을 변경할 수 없음
	final int fage =  10;
	
	//상수 정의
	public static final int START = 0;
	public static final int CONTINUE = 1;
	public static final int END = -1;
	
	//Constructor
	public AnimalAccessModifier() {
		
	}
	public AnimalAccessModifier(String pname, int page) {
		this.name3 = pname;
		this.age3 = page;
	}
	//Method
	//getter/setter
	//중요한 값이라 private로 숨기긴 해야하지만 공유하면서 값을 사용할때
	//getter와 setter를 이용한다.

	public String getPname() { //값을 보냄
		return name3; 
	}
	public int getPage() {
		return age3; 
	}
	
	public void setPname(String pname) { //값을 받음
		this.name3 = pname;
	}
	public void setPage(int page) {
		this.age3 = page;
	}
	
	//static method
	void getInfo() { //default니깐 같은 패키지에서만 호출가능한 메소드
		System.out.println(name3 + "," + age3);
	}; 
	public void getInfo2() {
		System.out.println(name3 + "," + age3);
	}
	static public void getInfo3() {
		System.out.println(sname + "," + sage);
	}

}
