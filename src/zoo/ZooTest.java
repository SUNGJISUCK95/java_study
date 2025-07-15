package zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooTest {

	public static void main(String[] args) {
		
		//객체 기반
		Lion lion = new Lion();
		lion.eat();
		lion.sleep();		
		
		//인터페이스 기반
		AnimalInterface lion2 = new Lion("심바아빠", 10);
		lion2.eat();
		lion2.sleep();
		
		AnimalInterface tiger2 = new Tiger("호랑아빠", 10);
		tiger2.eat();
		tiger2.sleep();
		
		
		List<Lion> list = new ArrayList<Lion>(); 
		//타입이 Lion이기 때문에 Lion만 사용가능
		
		List<AnimalInterface> list2 = new ArrayList<AnimalInterface>(); 
		//타입이 AnimalInterface이기 때문에 AnimalInterface에 상속받은 모든 자식들이 사용가능
	
		Lion lion1 = new Lion();
		Tiger tiger1 = new Tiger();
		list.add(lion1);
//		list.add(tiger1); //list에는 Lion만 들어갈 수 있어서 tiger1는 안됨
		
		list2.add(lion1);
		list2.add(tiger1); //list2에는 Tiger가 상속 되어있어 tiger1이 사용됨 => 자동(묵시적)형변환
		
		list.get(0).sleep(); //list의 0번지까지가 Lion을 의미하므로 '심바잠들다'가 출력
		
		list2.get(0).sleep(); //list2의 0번지가 Lion
		list2.get(1).sleep(); //list2의 1번지가 Tiger
		
		System.out.println(list2.get(0).getName()); //list2의 0번지가 Lion의 getName
		System.out.println(list2.get(1).getName()); //list2의 1번지가 Tiger의 getName
		
		Lion lion3 = (Lion)list2.get(0); //객체의 저장된 속성(값)은 강제(명시적) 형변환을 통해 진행
		System.out.println("lion3.name -> " + lion3.name);
	}

}
