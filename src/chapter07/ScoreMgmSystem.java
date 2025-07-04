package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 */
public class ScoreMgmSystem {
	//Field : 멤버변수, 전역변수
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);	
	Student[] sList = new Student[10];	
	int count = 0;
	
	
	//Constructor
	public ScoreMgmSystem() {
		
	}
	
	
	//Method
	/*
	 * 메뉴 선택
	 */
	public void showMemu() {
		System.out.println("-------------------");
		System.out.println("더조은 고등학교 성적관리 프로그램");
		System.out.println("-------------------");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 리스트 출력");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 학생 삭제");
		System.out.println("9. 프로그램 종료");
		System.out.println("-------------------");
		
		System.out.println("메뉴선택 >");
		
		menuCheck(scan.nextInt());
//		또는
//		int menu = scan.nextInt(); 	
//		choiceMenu(menu); //호출할 때 넘기는 값 : 파라미터
	}
	
	/*
	 * 선택한 메뉴에 따라 기능별 메소드 호출
	 */
	public void menuCheck(int menu) {
		switch(menu) { //메소드를 호출하여 계속 반복하는 행위 : 재귀호출
			case 1:
				insert(); 
				showMemu();
				break;
			case 2:
				show();
				showMemu();
				break;
			case 3:
				search();
				showMemu();
				break;
			case 4:
				update();
				showMemu();
				break;
			case 5:
				remove();
				showMemu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴 준비중 입니다.");
				showMemu();
		}
//		System.out.println("choiceMenu --> " + menu);
	}
	
//	insert(), update(), remove(), search()
	public void insert() {		
//		System.out.println("-- insert --");
		//student = new Student(); //단수 등록		
		boolean insertFlag = true;
		
		while(insertFlag) {
			sList[count] = new Student(); //복수 등록
			
			System.out.println("학생명 > ");
			sList[count].name = scan.next();
			
			System.out.println("국어 > ");
			sList[count].kor = scan.nextInt();
			
			System.out.println("영어 > ");
			sList[count].eng = scan.nextInt();
			
			System.out.println("수학 > ");
			sList[count].math = scan.nextInt();
	
			System.out.println("등록 완료");
			
			count++;
			if(count==sList.length) {
				System.out.println("학생 수 가 꽉찼습니다.");
				insertFlag = false;	
			}
			
			System.out.println("추가 등록하시겠습니까?(추가: 아무키, 종료: n)");
			if(scan.next().equals("n")){
				insertFlag = false;				
			}
			
			
			
		}
	}
	
	public void show() {
		if(count != 0) {
			System.out.println("-------------------");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("-------------------");
			for(int i=0; i<count; i++) {
				showIndex(i);	
			}
			System.out.println("-------------------");
		}else {
			System.out.println("등록된 학생이 없습니다.");
		}
	}
	
	public void search() {
		boolean searchFlag = true;
		
		if(count != 0) {
					int searchIdx = searchIndex(1);					
					
					if(searchIdx != -1) {
						System.out.println("===============================");
						System.out.println("\t\t검색 결과");
						System.out.println("===============================");
						System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
						System.out.println("===============================");
						showIndex(searchIdx);	
					
						System.out.println("추가로 검색하시겠습니까?(검색:아무키, 종료:n)");
						if(scan.next().equals("n")) {
							//종료
							showMemu();
						} else {
							search();
						}
					}else {
						System.out.println("해당 학생이 존재하지 않습니다.\n다시 입력해주세요.");
						search();
					}
		}else {
				System.out.println("검색한 데이터가 없습니다.");
		}
	}
	
	public void update() {
//		System.out.println("update");
		boolean modiFlag = true;
		
		if(count !=0) {
				int modiIdx = searchIndex(2);
				
				if(modiIdx != -1) {							
					System.out.println("국어 > ");
					sList[modiIdx].kor = scan.nextInt();
					
					System.out.println("영어 > ");
					sList[modiIdx].eng = scan.nextInt();
					
					System.out.println("수학 > ");
					sList[modiIdx].math = scan.nextInt();
					
					System.out.println("===============================");
					System.out.println("수정완료");
					System.out.println("===============================");
					System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
					System.out.println("===============================");
					showIndex(modiIdx);			
					System.out.println();
					
					System.out.println("계속 진행 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
					if(scan.next().equals("n")) {
						//종료
						showMemu();
					}else {
						update();
					}
				}else {
					System.out.println("해당 학생이 존재하지 않습니다.\n다시 입력해주세요.");
					update();
				}					
		} else {
			System.out.println("등록된 데이터가 없습니다. 등록을 진행해주세요.");
		}
	}
	
	public void remove() {
//		System.out.println("remove");
		if(count != 0) {
				int deleteIdx = searchIndex(3);
						
				if(deleteIdx != -1) {
					for(int i=deleteIdx; i<count-1; i++) {
							sList[i] = sList[i+1];
							//주소값이 이동해서 2중 배열이여도 행만 옮겨주면 된다.
					}
					sList[count-1] = null;
					count--;
							
					System.out.println("계속 진행 하시겠습니까?(계속:아무키 입력, 종료:n)> ");
					if(scan.next().equals("n")) {
								//종료
						show();
					}else {
						remove();
					}
							
				} else {
					System.out.println("해당 학생이 존재하지 않습니다.\n다시 입력해주세요.");
					remove();
				}
		} else {
			System.out.println("등록된 데이터가 없습니다. 등록을 진행해주세요.");
		}
	}
	
	/*
	 * 학생명을 검색하여 주소를 리턴하는 메소드
	 */
	
	public int searchIndex(int x) {
		if(x==1) {
			System.out.println("검색 학생명 > ");
		}else if(x==2) {
			System.out.println("수정 학생명 > ");
		}else if(x==3) {
			System.out.println("삭제 학생명 > ");
		}
		
		String searchName = scan.next();
		
		int searchIdx = -1;
		
		for(int i=0; i<count; i++) {
			Student student = sList[i];
			if(student.name.equals(searchName)) {
				searchIdx = i;
			}
		}
		
		return searchIdx;
	}
	
	public void showIndex(int y) {
		System.out.print(sList[y].name+"\t");
		System.out.print(sList[y].kor+"\t");
		System.out.print(sList[y].eng+"\t");
		System.out.print(sList[y].math+"\t");
		System.out.print(sList[y].getTot()+"\t");
		System.out.print(sList[y].getAvg()+"\n");	
	}	
}
