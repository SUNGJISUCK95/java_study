package chapter03;

/*
 * 형변환 : 자동(묵시적) 형변환, 강제(명시적) 형변환
 */
public class TypeCastingTest {

	public static void main(String[] args) {
		//자동(묵시적) 형변환 : 작은 데이터 타입 > 큰 데이터 타입
		byte bdata = 1;
		short sdata = bdata;
		int idata = sdata;
		long ldata = idata;
		
		int number = 100;
		float fnumber = number;
		
		char str = 'A';
		int strNumber = str;
		
		//강제(명시적) 형변환: 큰 데이터 타입 < 작은 데이터 타입
		int inumber = 10000; //int = 4byte //byte = 1byte 
		byte bnumber = (byte)inumber; //inumber값에서 1byte만큼 잘라서 bnumber 값으로 선언
		
		double dnumber = 12345.37; //double = 8byte //int = 4byte
		int inumber2 = (int)dnumber;
		
		System.out.println(ldata);
		System.out.println(fnumber);
		System.out.println(strNumber);
		
		System.out.println(bnumber);
		System.out.println(inumber2);
	}

}
