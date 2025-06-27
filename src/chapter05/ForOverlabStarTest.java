package chapter05;

import java.util.Scanner;

/*
 [시작]
 * 
 **
 ***
 ****
 *****
 [종료]
 */
public class ForOverlabStarTest {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				if(i>=j) {
					System.out.print("*");
				}
				System.out.println();	
			}
		}
	}
}	
