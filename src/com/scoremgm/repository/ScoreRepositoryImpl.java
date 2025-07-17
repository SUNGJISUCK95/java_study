package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.List;

import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository{
	List<Member> storage = new ArrayList<Member>(); 
//	부모<타입> 변수명 = new 자식<타입>();
//	                   생성자
	
	public boolean insert(Member member) {
		if(member == null) return false;
		return storage.add(member);
		
//		System.out.println("storage.size() --> " + storage.size()); //add가 잘 적용 됐는지 확인 => 1이뜨면 성공
		
	}
	
	@Override
	public int getCount() { //학생 정보가 등록되면 1씩 카운트 하는 함수
		return storage.size();
	}
	
	public List<Member> findAll(){
		return storage;
	
	}
}
