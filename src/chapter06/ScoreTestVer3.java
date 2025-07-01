package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer2의 결과에 메뉴를 추가함
 */
public class ScoreTestVer3 {

	public static void main(String[] args) {
//		String[] menuBox = {"학생 등록","학생 리스트 출력","학생 성적 검색"};
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		boolean menuFlag = true;
		System.out.println("크기입력> ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[] korList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		int count = 0; //등록된 학생 수 저장
		
		while(menuFlag) {
			System.out.println("===============================");
			System.out.println(" 더조은 고등학교 1-1 성적관리 프로그램");
			System.out.println("===============================");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 리스트 출력");
			System.out.println("3. 학생 성적 검색");
			System.out.println("9. 프로그램 종료");
			System.out.println("===============================");

			System.out.println("메뉴 선택> ");
			menu = scan.nextInt();
		
//			System.out.println("선택메뉴> " + menuBox[menu-1]);

			if(menu == 1) { //학생 등록
				for(int i=count; i<nameList.length; i++){
					System.out.println("학생명>");
					nameList[i] = scan.next();
					
					System.out.println(nameList[i] + "의 국어점수> ");
					korList[i] = scan.nextInt();
					
					System.out.println(nameList[i] + "의 영어점수> ");
					engList[i] = scan.nextInt();
					
					System.out.println(nameList[i] + "의 수학점수> ");
					mathList[i] = scan.nextInt();
					
					totList[i] = korList[i] + engList[i] + mathList[i];
					avgList[i] = totList[i]/3;
					
					count++;
					
					System.out.println("계속 입력 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
					if(scan.next().equals("n")) {
						//종료
						System.out.println("학생 등록 종료");
						break; //또는 i = nameList.length;
					}

				}
			} else if(menu == 2) { //학생 리스트 출력
				if(count != 0) { // 또는 nameList[0] != null
					System.out.println("===============================");
					System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
					System.out.println("===============================");
					for(int i=0; i<nameList.length; i++) {
						if(nameList[i] != null) {				
							System.out.print(nameList[i]+"\t");
							System.out.print(korList[i]+"\t");
							System.out.print(engList[i]+"\t");
							System.out.print(mathList[i]+"\t");
							System.out.print(totList[i]+"\t");
							System.out.print(avgList[i]+"\n");
						}
					}	
				}else {
					System.out.println("학생 등록을 먼저 진행해 주세요.");
				}
			} else if(menu == 3) { //학생 성적 검색
				if(count != 0) {
					boolean searchFlag = true;
					
					
					while(searchFlag) {
						System.out.println("학생명 검색> ");
						String searchName = scan.next();
						//nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다.
						
						int searchIdx = -1;
						int count2 = 0;
						
						for(String name : nameList) { 
						//nameList의 배열 수 만큼 for문 루프
							if(name != null) { 
							//nameList의 배열 수는 5개이므로 무조건 5번 돌아서 null값 체크
								if(name.equals(searchName)) {
									//searchName에 입력한 이름과 nameList에 있는 이름과 동일하면	
									searchIdx = count2;
									//같으면 배열번호 저장
								}
									
								count2++;
								
							}
						}
						if(searchIdx != -1) {
							System.out.println("검색결과 주소 : " + searchIdx);
							
							//Step5 : 데이터 조회 결과 출력
							System.out.println("===============================");
							System.out.println("\t\t검색 결과");
							System.out.println("===============================");
							System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
							System.out.println("===============================");
							System.out.print(nameList[searchIdx]+"\t");
							System.out.print(korList[searchIdx]+"\t");
							System.out.print(engList[searchIdx]+"\t");
							System.out.print(mathList[searchIdx]+"\t");
							System.out.print(totList[searchIdx]+"\t");
							System.out.print(avgList[searchIdx]+"\n");
							
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
			} else if(menu == 9) { //프로그램 종료
				System.out.println("프로그램 종료");
				System.exit(0);
			} else {
				System.out.println("메뉴 준비중 입니다.");
			}

//			System.out.println("계속 진행 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
//			if(scan.next().equals("n")) {
//				//종료
//				break; //또는 menuFlag = false;
//			}
		}
		
		System.out.println("프로그램 종료");
		
	}

}
