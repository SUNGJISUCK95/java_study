package zoo;

/**
 * 동물의 공통적인 속성
 * name, age
 */
public class Animal implements AnimalInterface{
	String name;
	int age;
	
	public Animal() {
		
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void sleep() {
		System.out.println(name + "잠들다");
	}
	
	@Override
	public void eat() {
		System.out.println(name + "먹다");
	}

	@Override
	public String getName() {
		return name;
	}


	@Override
	public int getAge() {
		return age;
	}
	
	
}
