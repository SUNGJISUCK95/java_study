package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.scoremgm.model.MemberVo;

import db.DBConn;
import db.GenericRepositoryInterface;

public class ScoreRepositoryImpl extends DBConn 
								 implements GenericRepositoryInterface<MemberVo> {
//	List<MemberVo> storage = new ArrayList<MemberVo>(); 
//	부모<타입> 변수명 = new 자식<타입>();
//	                   생성자
	
	public ScoreRepositoryImpl() {
		super();
	}
	
	@Override
	public int insert(MemberVo member) {
		int rows = 0;
		
		String sql = """
					 INSERT INTO score_member(name, department, kor, eng, math, mdate) 
					             values (?, ?, ?, ?, ?, now())
					 """;
		
		try {		     	
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getDepartment());	
			pstmt.setInt(3, member.getKor());
			pstmt.setInt(4, member.getEng());
			pstmt.setInt(5, member.getMath());
			rows = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
		
	}
	
	@Override
	public int getCount() { //학생 정보가 등록되면 1씩 카운트 하는 함수
		int rows = 0;
		String sql = "SELECT count(*) FROM score_member";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@Override
	public List<MemberVo> findAll(){
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
					 SELECT 
					 	row_number() over(), 
					 	mid, name, department, kor, eng, math, mdate
					 FROM score_member
					 """;
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setRno(rs.getInt(1));
				member.setMid(rs.getString(2));
				member.setName(rs.getString(3));
				member.setDepartment(rs.getString(4));
				member.setKor(rs.getInt(5));
				member.setEng(rs.getInt(6));
				member.setMath(rs.getInt(7));
				member.setMdate(rs.getString(8));
				
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public MemberVo find(String mid) {	
		MemberVo member = null;
		
		String sql = """
					 SELECT mid, name, department, kor, eng, math, mdate
					 FROM score_member
					 WHERE mid = ?  
					 """;
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVo();
				member.setMid(rs.getString(1));
				member.setName(rs.getString(2));
				member.setDepartment(rs.getString(3));
				member.setKor(rs.getInt(4));
				member.setEng(rs.getInt(5));
				member.setMath(rs.getInt(6));
				member.setMdate(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	@Override
	public int update(MemberVo member) {
		int rows = 0;
		
		String sql = """
					 UPDATE score_member
					 SET kor = ?, eng = ?, math = ?
					 WHERE mid = ?
					 """; //국,영,수 점수 업데이트
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, member.getKor());
			pstmt.setInt(2, member.getEng());
			pstmt.setInt(3, member.getMath());
			pstmt.setString(4, member.getMid());
			
			rows = pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@Override
	public int remove(String mid) {
		int rows = 0;
		
		String sql = """
					 DELETE FROM score_member
					 WHERE mid = ?
					 """;
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, mid);
			
			rows = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
}
