package javadoc;

public class JavaDocTest {

	public static void main(String[] args) {
		javaDoc jdoc = new javaDoc();
		jdoc.setName("홍길동");
		jdoc.setAge(10);
		
		System.out.println(jdoc.getName());
		System.out.println(jdoc.getAge());
	}

}
