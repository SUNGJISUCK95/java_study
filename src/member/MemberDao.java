package member;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class MemberDao extends DBConn implements GenericInterface<MemberVo>{ //GenericInterface의 T = MemberVo
																			 //원하는 타입만 지정해주면 다른 곳에서도 사용가능
																			 //ex) EmployeeVo, DepartmentVo ...
	//--3
	public MemberDao() { 
 		super(); //부모와 연동하는 전체 요소 가져오기
	}
	
	//CRUD 기능 구현 - 애플리케이션 기반의 DB연동은 기본적으로 Autocommit = true 임, 바로 적용됨
	
	//--4
	/**
	 * 데이터 추가
	 * @param memberVo
	 */
	@Override
	public int insert(MemberVo memberVo) {
		//--17
		int rows = 0;
		
		String sql = """
					 INSERT INTO member(name, email, created_at) 
					             values (?, ?, now())
					 """;
		
		try {		     	
			getPreparedStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getEmail());			
			rows = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	//--5
	/**
	 * 전체리스트
	 */
	@Override
	public List<MemberVo> listAll() {
		//--20
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select member_id, name, email, left(created_at, 10) from member";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
				
				list.add(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//--6
	/**
	 * 데이터 수정
	 */
	@Override
	public int update(MemberVo member) {
		//--23
		int rows = 0;
		
		String sql = """
					 UPDATE member 
					 SET name = ?, email = ? 
					 WHERE member_id = ?
					 """;
	
		try {		     	
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName()); //적은 값 가져와서 sql의 ? 부분에 넣음 //그래서 순서대로 해야함
			pstmt.setString(2, member.getEmail());			
			pstmt.setInt(3, member.getMemberId());	
			rows = pstmt.executeUpdate(); //update
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	//--7
	/**
	 * 데이터 삭제
	 */
	@Override
	public int delete(int memberId) { //삭제할 때는 id값 하나만 필요하므로 요소하나만 선정
		//--25
		int rows = 0;
		
		String sql = """
					 DELETE FROM member 
					 WHERE member_id = ?
					 """;
		
		try {		     	
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId); //적은 값 가져와서 sql의 ? 부분에 넣음 //그래서 순서대로 해야함
			rows = pstmt.executeUpdate(); //delete
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	//--9
	/**
	 * 데이터 검색 //단일 데이터
	 */
	@Override
	public MemberVo search(int memberId) {
		MemberVo member = new MemberVo();
		String sql = "SELECT member_id, name, email, created_at "
				     + "FROM member "
				     + "WHERE member_id = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	};
	
	//--10
	/**
	 * 데이터 검색 //복수 데이터
	 */
	@Override
	public List<MemberVo> search(String name){ // 오버로딩 : 타입만 바꿔 동일 클래스 생성
		//--11
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
					 SELECT member_id,
						name,
					    email,
					    created_at
					 FROM member
					 WHERE name = ? 
					 """; 
					 // ? 표 개수에 따라 받아야 하는 매개변수 수도 같아야한다.
					 // ? 는 컬럼 선언 순서에 따라 줘야한다.
		
		//--12
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setMemberId(rs.getInt(1));
				memberVo.setName(rs.getString(2));
				memberVo.setEmail(rs.getString(3));
				memberVo.setCreatedAt(rs.getString(4));
				
				list.add(memberVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	};
}
