package chapter06;

import java.util.Arrays;

/*
 * 배열 복사 : for, System.arrayCopy(), Arrays.copyOf()
 */
public class ArrayCopyTest {

	public static void main(String[] args) {
		// 1.for
		int[] arrInt = {1,2,3};
		int[] arrInt2 = new int[5];
		int[] arrInt3 = new int[3]; //System.arrayCopy()

		
		for(int i=0; i<arrInt.length; i++) {
			arrInt2[i] = arrInt[i];
		}
		
		for(int i=0; i<arrInt2.length; i++) {
			System.out.print(arrInt2[i] + "\t");
		}
		
		//2. System.arrayCopy()
		System.arraycopy(arrInt, 0, arrInt3, 0, arrInt.length);
		System.out.println();
		for(int i=0; i<arrInt3.length; i++) {
			System.out.print(arrInt3[i] + "\t");
		}
		
		//3. Arrays.copyOf()
		int[] arrInt4 = Arrays.copyOf(arrInt, arrInt.length);
		//arrInt의 데이터를 arrInt4에 arrInt의 배열 수 만큼 복사 복사
		System.out.println();
		for(int i=0; i<arrInt4.length; i++) {
			System.out.print(arrInt4[i] + "\t");
		}
	}

}
