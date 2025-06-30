package chapter06;

public class ArrayTest05 {

	public static void main(String[] args) {
		int[] nlist = new int[3];
		//nlist = "1"; //배열 번호와 타입이 다르므로 사용 불가 //Type mismatch
		//nlist[3] = 99; //Runtime시에 ArrayIndexOutOfException 발생
		//없는 배열번호에 값을 입력해도 타입만 체크해서 실행 전 에러는 안뜸
		//하지만 코드를 실행하면 [3]배열은 없다고 에러가 뜸
		
		System.out.println(nlist.hashCode());
		
		for(int i=0; i<nlist.length; i++) {
			System.out.println(nlist[i]);
		}
		
//		for(int i=0; i<5; i++) { //배열 도는 횟수를 오버하면 오버된 배열부터 에러가 출력된다.
//			System.out.println(nlist[i]);
//		}

	}

}
