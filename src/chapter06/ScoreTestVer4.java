package chapter06;

import java.util.Scanner;

/*
 * ScoreTestVer3의 점수 저장을 2차원 구조로 수정함
 */
public class ScoreTestVer4 {

	public static void main(String[] args) {
//		String[] menuBox = {"학생 등록","학생 리스트 출력","학생 성적 검색"};
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		boolean menuFlag = true;
		System.out.println("크기입력> ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList = new String[MAX_SIZE];
		int[][] scoreList = new int[MAX_SIZE][];
		
		int count = 0; //등록된 학생 수 저장
		
		while(menuFlag) {
			System.out.println("===============================");
			System.out.println(" 더조은 고등학교 1-1 성적관리 프로그램");
			System.out.println("===============================");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 리스트 출력");
			System.out.println("3. 학생 성적 검색");
			System.out.println("4. 학생 성적 수정");
			System.out.println("5. 학생 삭제");
			System.out.println("9. 프로그램 종료");
			System.out.println("===============================");

			System.out.println("메뉴 선택> ");
			menu = scan.nextInt();
		
//			System.out.println("선택메뉴> " + menuBox[menu-1]);

			if(menu == 1) { //학생 등록				
				for(int i=count; i<nameList.length; i++){
					String[] subjectlist = {"국어", "영어", "수학"};
					System.out.println("학생명>");
					nameList[i] = scan.next();
					
					//첫번째 학생의 점수를 입력할 배열을 생성함
					scoreList[i] = new int[5];
					int tot = 0;
					int avg = 0;
					
					for(int j=0; j<subjectlist.length; j++) {
						System.out.println(subjectlist[j] + "> ");
						scoreList[i][j] = scan.nextInt();
						tot += scoreList[i][j];
						avg = tot/3;
					}
					
					scoreList[i][scoreList[i].length-2] = tot;
					scoreList[i][scoreList[i].length-1] = avg;
					
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
					for(int i=0; i<count; i++) {			
							System.out.print(nameList[i]+"\t");
							for(int j=0; j<scoreList[i].length; j++) {
								System.out.print(scoreList[i][j]+"\t");
							}
							System.out.println();
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
							for(int score : scoreList[searchIdx]) {
								System.out.print(score + "\t");
							}
							System.out.println();
							
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
			} else if(menu == 4){
				//1. 수정할 학생명이 존재여부 검색 : 유-> 새로운 성적입력 후 수정
				//1. 수정할 학생명이 존재여부 검색 : 무-> 검색 데이터 존재 x, 반복진행
				String[] subjectlist = {"국어", "영어", "수학"};
				int tot = 0;
				int avg = 0;
				boolean modiFlag = true;
				
				if(count !=0) {
					while(modiFlag) {
						System.out.println("수정 할 학생명 검색>");
						String modifiedName = scan.next();
						int modiIdx = -1;
						
						for(int i=0; i<count; i++) {
							if(nameList[i].equals(modifiedName)) {
								modiIdx = i;
							}
						}
						
						if(modiIdx != -1) {
							for(int j=0; j<subjectlist.length; j++) {
								System.out.println(subjectlist[j] + "> ");
								scoreList[modiIdx][j] = scan.nextInt();
								tot += scoreList[modiIdx][j];
								avg = tot/3;
							}
							
							scoreList[modiIdx][scoreList[modiIdx].length-2] = tot;
							scoreList[modiIdx][scoreList[modiIdx].length-1] = avg;
							
							System.out.println("수정완료");
							System.out.println("===============================");
							System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
							System.out.println("===============================");
							System.out.print(nameList[modiIdx]+"\t");
							for(int score : scoreList[modiIdx]) {
								System.out.print(score + "\t");
							}
//							또는
//							for(int j=0; j<scoreList[modiIdx].length; j++) {
//								System.out.print(scoreList[modiIdx][j]+"\t");
//							}							
							
							System.out.println();
							
							System.out.println("계속 진행 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
							if(scan.next().equals("n")) {
								//종료
								break; //또는 modiFlag = false;
							}
						}else {
							System.out.println("해당 학생이 존재하지 않습니다.\n다시 입력해주세요.");
						}					
					}
				} else {
					System.out.println("등록된 데이터가 없습니다. 등록을 진행해주세요.");
				}
				
			} else if(menu == 5) { //학생 삭제
				if(count != -1) {
					boolean deleteFlag = true;
					while(deleteFlag) {
						System.out.println("삭제 할 학생명 검색>");
						String deleteName = scan.next();
						int deleteIdx = -1;
						for(int i=0; i<count; i++) {
							if(nameList[i].equals(deleteName)) {
								deleteIdx = i;
							}
						}
						
						if(deleteIdx != -1) {
							for(int i=deleteIdx; i<count-1; i++) {
									nameList[i] = nameList[i+1];
									scoreList[i] = scoreList[i+1];
									//주소값이 이동해서 2중 배열이여도 행만 옮겨주면 된다.
							}
							count--;
							
							System.out.println("계속 진행 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
							if(scan.next().equals("n")) {
								//종료
								break; //또는 deleteFlag = false;
							}
							
						} else {
							System.out.println("해당 학생이 존재하지 않습니다.\n다시 입력해주세요.");
						}
					}// while-deleteFlag
				} else {
					System.out.println("등록된 데이터가 없습니다. 등록을 진행해주세요.");
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
