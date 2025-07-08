package drink;

public class Payment {
	//Field
	int amount; //결제할 금액
	int change;
	
	//Constructor
	public Payment() {
		
	}
	
	//Method
	public void setAmount(int amount) {
		this.amount += amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getChange() {
		return change;
	}
	
	public boolean getPatment(int total) {
		boolean result = false;
		if(amount >= total) {
			change = amount - total ;
			result = true;
		}
		
		return result;
	}
	
}
