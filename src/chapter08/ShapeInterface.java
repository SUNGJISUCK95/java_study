package chapter08;

/**
 * 추상 메소드들을 모아놓은 그룹
 */
public interface ShapeInterface {
	//interface에는 이미 abstract(추상)이 자동으로 메소드에 붙어서 기입하지 않아도 된다.
	//추상 메소드의 모음이기 때문에
	public void draw();
	public double getArea();
}
