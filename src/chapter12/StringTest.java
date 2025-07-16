package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String num = String.valueOf(123); //숫자를 문자열로 변경
		name2 = "welcomeToJava";
		
		String phone = "010-1234-5678";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-"); //해당 문자열을 기준으로 분할 {"010","1234","5678"}
		String[] subjects = subject.split(","); //{"java", "css", "html", "mysql"}
		
		String jphone = String.join("," , phones); //분할 된 문자열을 지정한 문자를 기준으로 출력
		
		System.out.println(subject.contains("html")); //해당 변수에 지정한 문자열이 있는지 체크 boolean형
		System.out.println(jphone);
		System.out.println(phones[0]);
		System.out.println(subjects[0]);
		System.out.println(name2.toUpperCase()); //toUpperCase는 전부 대문자 출력
		System.out.println(name2.toLowerCase()); //toLowerCase 전부 소문자 출력
		System.out.println(name2.length()); //문자열의 길이
		System.out.println(name2.substring(7)); //지정한 숫자(7)부터 끝까지 출력
		System.out.println(name2.substring(7, 10)); //7번째부터 시작해서 9번째까지 출력 //10으로 지정했지만 그 전까지 출력
		
		
		System.out.println(num+10); //num은 문자열로 변경되어서 12310으로 출력
		System.out.println(System.identityHashCode(name1)); //기본데이터 이지만 heap에 생성된 것처럼 hashcode를 받을 수 있음
		System.out.println(System.identityHashCode(name2)); //heap에 생성된 hashcode를 받을 수 있음
		
		//name1은 기본데이터 타입이고 stack값이고, name2는 String 생성자로 만들어서 heap의 주소값이다.
		if(name1 == name2) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		//equals는 객채로 지정해줘서 동일
		if(name1.equals(name2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}

}
