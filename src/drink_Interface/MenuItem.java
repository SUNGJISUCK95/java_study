package drink_Interface;

public class MenuItem implements Menu{
	//Field
	int no;
	String name;
	int price;
	//Constructor
	public MenuItem() {
		
	}
	public MenuItem(int no, String name, int price) {
			this.no = no;
			this.name = name;
			this.price = price;
	}
	
	//Method
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	public int getNo() {
		return no;
	}
}
