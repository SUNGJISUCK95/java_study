package drink;

public class Menu {
	//Field
	int no;
	String name;
	int price;
	//Constructor
	public Menu() {
		
	}
	public Menu(int no, String name, int price) {
			this.no = no;
			this.name = name;
			this.price = price;
	}
	//Method
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getNo() {
		return no;
	}
}
