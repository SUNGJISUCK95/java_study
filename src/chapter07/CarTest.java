package chapter07;

public class CarTest {

	public static void main(String[] args) {
		//1. 객체 생성
		Car avante = new Car();
		//Car가 실행하면서 Car.java에 지정한 name,company가 method area에 저장되어 호출하여 사용이 가능하다.
		Car ev6 = new Car();
		
		//2. 객체 데이터 할당
		avante.name = "아반테"; 
		avante.company = "현대자동차";
		avante.price = 1000;
		
		ev6.name = "EV6"; 
		ev6.company = "기아자동차";
		ev6.price = 2000;
		
		//3. 메소드 호출
		System.out.println("*******************");
		System.out.println("\tCar Information");
		System.out.println("*******************");
		//각 메소드 호출 종료 시 main으로 돌아가는 복귀주소(리턴주소)를 갖는다.
		avante.showInfo(); //1. avante관련해서 함수돌고
		ev6.showInfo(); //2. 다시 Car.java로 가서 ev6관련해서 함수돌고 종료
		System.out.println("main 메소드 종료"); //3.다시 main 메소드로 돌아와서 종료
		//변수명.하면 method area에 저장된 호출 정보를 볼 수 있다.
	}

}
