package zoo;

public class Tiger extends Animal {
	
	public Tiger() {
		this("호랑", 5); //default 값
	}
	
	public Tiger(String name, int age) {
		super(name, age); //부모클래스에 전달
	}
}
