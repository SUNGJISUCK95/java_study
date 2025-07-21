package com.bookmgm.app;

import java.util.Scanner;

import com.bookmgm.service.BookService;
import com.bookmgm.service.DefaultBookService;

//작업을 다른 클래스로 넘기는 영역
public class BookManagementApplication {
	public static final int REGISTER = 1;
	public static final int LIST = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EIXT = 6;
	public Scanner scan;
	BookService service;
	
	public BookManagementApplication() {
		scan = new Scanner(System.in);
		service = new DefaultBookService(this); 
		//service 생성자를 안열어 주면 주소값이 null 이므로 nullPointException이 발생
		//DefaultBookService는 자식 클래스이므로 생성자 가능
		showMenu();
	}
	
	public static void main(String[] args) { //실행되는 함수는 많지만 main 메소드에 main Thread는 하나이다.
		new BookManagementApplication();

	}
	
	/**
	 * 메뉴 출력
	 */
//	1. 도서 등록
//	2. 도서 목록 조회
//	3. 도서 검색
//	4. 도서 수정
//	5. 도서 삭제
//	6. 종료1
	public void showMenu() {
		//배열을 이용하여 메뉴 생성
		String[] menuList = {"도서 등록", "도서 목록 조회", "도서 검색", "도서 수정", "도서 삭제", "종료"};
		
		System.out.println("전체 도서수 : " + service.getCount());
		System.out.println("-------------------------------------------------------");
		System.out.println("도서관리 시스템");
		System.out.println("-------------------------------------------------------");
		for(int i=0; i<menuList.length; i++) {
			System.out.println((i+1) + ". " + menuList[i]);
		}
		System.out.println("-------------------------------------------------------");
		System.out.print("메뉴 선택> ");		
		selectMenu();
		
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {	
		if(scan.hasNextInt()) {
			int menu_no = scan.nextInt();
			switch(menu_no) {
				case REGISTER : {
					service.register();
					break;
				}			
				case LIST : {
					service.list();
					break;
				}			
				case SEARCH : {
					service.search();
					break;
				}			
				case UPDATE : {
					service.update();
					break;
				}
				case DELETE : {
					service.delete();
					break;
				}
				case EIXT : {
					service.eixt();
					break;
				}
				default : {
					System.out.println("메뉴 준비중");
					showMenu();
				}
			}
		}else {
			System.out.println("잘못된 입력입니다. 재입력 해주세요.");
			scan.next(); //scan 사용할때 else문에서 빈값 줘야 넘어가서 필수
			showMenu();
		}
	}
}
