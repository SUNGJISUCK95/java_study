package chapter17;

public class MainTreadTest {

	public static void main(String[] args) { 
	//main메소드는 main Thread를 가지고 있다. 
	//stack, heap의 메모리작업 등을 main Thread가 처리해준다.
		
		//1 ~ 10 정수 출력
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
	
		ThreadExtend te = new ThreadExtend(); //te Thread : 독립 실행 - 각자 실행 후 종료
		//별개의 Thread는 main Thread의 간섭을 받지않는다. (별도 실행)
		te.start();
		
		Thread t = new Thread(new RunnableImpl()); //t Thread : 독립 실행
		t.start();
		
		
		System.out.println("main 메소드 종료"); //main Thread도 종료된다.
	}

}
