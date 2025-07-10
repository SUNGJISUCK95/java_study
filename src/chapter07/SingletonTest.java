package chapter07;

public class SingletonTest {

	public static void main(String[] args) {
		//생성자가 private으로 접근제어 됨
//		Singleton singleton = new Singleton();
		
		//static은 메소드로 호출
		Singleton singleton = Singleton.getInstance();
		
		//privte는 get, set으로 호출
		singleton.setName("싱글톤");
		System.out.println("name : " + singleton.getName());
	} 

}
