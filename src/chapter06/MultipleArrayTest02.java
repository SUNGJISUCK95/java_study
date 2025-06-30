package chapter06;

public class MultipleArrayTest02 {

	public static void main(String[] args) {
		// 가변형 배열 생성 : 3행으 구조에 열은 1부터 하나씩 증가하는 구조
		int[][] matrix = new int[3][];
		
		matrix[0] = new int[1];
		matrix[1] = new int[2];
		matrix[2] = new int[3];
		
		int count = 1; //카운트 변수
		
		for(int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = count;
				count++;
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

	}

}
