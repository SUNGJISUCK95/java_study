package member;

import java.util.List;

public class MemberTest {

	public static void main(String[] args) {
		//--13
//		MemberDao memberDao = new MemberDao();
		
		//-- 14 데이터 검색 //복수 데이터
//		List<MemberVo> list = memberDao.search("홍길동");
//		if(list.size() != 0) { 
//		//memberDao.search()에서 list는 주소값은 가지고 있어서 null이 아니므로 테이블에 없는 값이여도 if이 true가 된다 ex) if(list != null) 동작 X
//			list.forEach((member) -> {
//				System.out.print(member.getMemberId() + "\t");
//				System.out.print(member.getName() + "\t");
//				System.out.print(member.getEmail() + "\t");
//				System.out.print(member.getCreatedAt() + "\n");
//			});
//			System.out.println("데이터 출력");
//		}
		
		//-- 14 데이터 검색 //단일 데이터
//		MemberVo member = memberDao.search(3);
//		if(member.getMemberId() != 0) {
//			System.out.print(member.getMemberId() + "\t");
//			System.out.print(member.getName() + "\t");
//			System.out.print(member.getEmail() + "\t");
//			System.out.print(member.getCreatedAt() + "\n");
//		}
		
		MemberApp memberApp = new MemberApp();
	}

}
