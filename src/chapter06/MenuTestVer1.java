package chapter06;

import java.util.Scanner;

/*
 * 더조은 레스토랑 메뉴 등록/출력/검색 프로그램
 * - 메뉴는 피자, 햄버거, 라멘, 샐러드
 * - 메뉴명, 이모지, 가격을 저장
 * - 메뉴명 이모지, 가격은 각각 1차원 배열로 생성하여 관리
 * - 메뉴 관리를 위해서 각 배열의 주소를 통일시킨다.
 */
public class MenuTestVer1 {

	public static void main(String[] args) {
		//변수 or 객체 선언
		Scanner scan = new Scanner(System.in);
		
		System.out.println("메뉴 갯수> ");
		final int MAX_SIZE = scan.nextInt();
		String nameList[] = new String[MAX_SIZE];
		String emoList[] = new String[MAX_SIZE];
		int priceList[] = new int[MAX_SIZE];
		
		int count = 0; //등록된 메뉴 수 저장
		
		//메뉴 등록/출력/검색/종료
		boolean menuFlag = true;
		int menu = 0;
		while(menuFlag) {
			System.out.println("===============================");
			System.out.println(" 더조은 레스토랑 메뉴 관리 프로그램");
			System.out.println("===============================");
			System.out.println("1. 메뉴 등록");
			System.out.println("2. 메뉴 리스트 출력");
			System.out.println("3. 메뉴 검색");
			System.out.println("9. 프로그램 종료");
			System.out.println("===============================");

			System.out.println("메뉴 선택> ");
			menu = scan.nextInt();
			
			
			//메뉴 체크
			if(menu == 1) { //메뉴 등록
				for(int i=count; i<MAX_SIZE; i++){
					System.out.println("메뉴명>");
					nameList[i] = scan.next();
					
					System.out.println(nameList[i] + "의 이모지> ");
					emoList[i] = scan.next();
					
					System.out.println(nameList[i] + "의 가격> ");
					priceList[i] = scan.nextInt();
					
					count++;
					
					if(count == MAX_SIZE) {
						System.out.println("저장공간 부족, 등록 종료");
					}else {
						System.out.println("계속 입력 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
						if(scan.next().equals("n")) {
							//종료
							System.out.println("메뉴 등록 종료");
							break; //또는 i = MAX_SIZE;
						}
					}

				}
			}else if(menu == 2) { //메뉴 리스트 출력
				if(count != 0) { // 또는 nameList[0] != null
					System.out.println("===================");
					System.out.println("메뉴명\t이모지\t가격");
					System.out.println("===================");
					for(int i=0; i<MAX_SIZE; i++) {
						if(nameList[i] != null) {				
							System.out.print(nameList[i]+"\t");
							System.out.print(emoList[i]+"\t");
							System.out.print(priceList[i]+"\n");
						}
					}	
				}else {
					System.out.println("메뉴 등록을 먼저 진행해 주세요.");
				}
			}else if(menu == 3) { //메뉴 성적 검색
				if(count != 0) {
					boolean searchFlag = true;					
					
					while(searchFlag) {
						System.out.println("메뉴명 검색> ");
						String searchName = scan.next();
						//nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
						
						int searchIdx = -1;
						
						for(int i=0; i<menu; i++) { 
								if(searchName.equals(nameList[i])) {
									searchIdx = i;
								}
						}
						if(searchIdx != -1) {
							System.out.println("검색결과 주소 : " + searchIdx);
							
							//Step5 : 데이터 조회 결과 출력
							System.out.println("===============================");
							System.out.println("\t\t검색 결과");
							System.out.println("===============================");
							System.out.println("메뉴명\t이모지\t가격");
							System.out.println("===============================");
							System.out.print(nameList[searchIdx]+"\t");
							System.out.print(emoList[searchIdx]+"\t");
							System.out.print(priceList[searchIdx]+"\n");
							
							System.out.println("추가로 검색하시겠습니까?(검색:아무키, 종료:n)");
							if(scan.next().equals("n")) {
								//종료
								searchFlag = false; //또는 break;
							}
						}else {
							System.out.println("검색한 데이터가 없습니다.");
						}
					}
				}else {
					System.out.println("학생 등록을 먼저 진행해 주세요.");
				}
			}else if(menu == 9) { //종료
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("메뉴 준비중 입니다.");
			}
		}
	}//main

}//class
