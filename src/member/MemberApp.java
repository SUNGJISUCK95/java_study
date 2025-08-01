package member;

import java.util.List;
import java.util.Scanner;

public class MemberApp {
	Scanner scan = new Scanner(System.in);
	
	public static final int INSERT = 1;
	public static final int LIST = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	public static final int EXIT = 0;
	MemberDao memberDao;
	
	public MemberApp() {
		memberDao = new MemberDao();
		showMenu();
		selectMenu();
	}
	
	public void showMenu() {
		System.out.println("***********************************************");
		System.out.println("\t1. 등록");
		System.out.println("\t2. 조회");
		System.out.println("\t3. 수정");
		System.out.println("\t4. 삭제");
		System.out.println("\t0. 종료");
		System.out.println("***********************************************");
	}
	
	public void selectMenu() {
		System.out.print("메뉴선택> ");
		int menuNo = scan.nextInt();
		switch(menuNo) {
			case INSERT : {
				insert();
				break;
			}
			case LIST : {
				list();
				break;
			}
			case UPDATE : {
				update();
				break;
			}
			case DELETE : {
				delete();
				break;
			}
			case EXIT : {
				System.out.println("프로그램 종료");
				memberDao.close();
				System.exit(0);
			}			
		}
	}
	
	public void insert() {
		//--15
		MemberVo member = new MemberVo();
		//--16
		System.out.println("=> 이름, 이메일을 입력해주세요.");
		System.out.print("이름> ");
		member.setName(scan.next());
		
		System.out.print("이메일> ");
		member.setEmail(scan.next());
		
		int result = memberDao.insert(member);
		if(result == 1) {
			System.out.println("=> 등록 성공");
		}else {
			System.out.println("=> 등록 실패");
		}
		showMenu();
		selectMenu();
	}
		
	public void list() {
		//--18
		List<MemberVo> list = memberDao.listAll();
		
		//--19
		System.out.println("***********************************************");
		System.out.println("아이디\t이름\t이메일\t\t등록일");
		System.out.println("***********************************************");
		
		if(list.size() != 0) { //size()로 list 안에 데이터가 있는지 체크
			list.forEach((member) -> {
				System.out.print(member.getMemberId() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getEmail() + "\t");
				System.out.print(member.getCreatedAt() + "\n");
			});			
		}else {
			System.out.println("=> 등록된 데이터가 없습니다.");
		}
		showMenu();
		selectMenu();
	}
	
	public void update() {
		//--22
		System.out.print("[검색]아이디> ");	
		//업데이틑 여부 확인 :
		MemberVo member = memberDao.search(scan.nextInt());
		if(member.getMemberId() != 0) {
			//업데이트 데이터를 입력
			System.out.println("[" + member.getName() + "] => 이름, 이메일을 입력해주세요.");
			System.out.print("[수정]이름> ");
			member.setName(scan.next());
			
			System.out.print("[수정]이메일> ");
			member.setEmail(scan.next());
			
			int result = memberDao.update(member); //member 객체에 member_id 반드시 존재해야함
			if(result == 1) {
				System.out.println("=> 업데이트 성공");
			}else {
				System.out.println("=> 업데이트 실패");
			}
		}else {
			System.out.println("=> 등록된 데이터가 없습니다.");
		}
		
		showMenu();
		selectMenu();
	}
	
	public void delete() {
		//--24
		System.out.print("[삭제]아이디> ");	
			
		int result = memberDao.delete(scan.nextInt()); //member 객체에 member_id 반드시 존재해야함
		if(result == 1) {
			System.out.println("=> 삭제 성공");
		}else {
			System.out.println("=> 삭제 실패");
		}
		
		showMenu();
		selectMenu();
	}
}
