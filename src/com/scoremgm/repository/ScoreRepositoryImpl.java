package com.scoremgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.scoremgm.model.Member;

public class ScoreRepositoryImpl implements ScoreRepository{
	List<Member> storage = new ArrayList<Member>(); 
//	부모<타입> 변수명 = new 자식<타입>();
//	                   생성자
	
	public boolean insert(Member member) {
		if(member == null) {
			return false;
		}else {
			return storage.add(member);
		}
//		System.out.println("storage.size() --> " + storage.size()); //add가 잘 적용 됐는지 확인 => 1이뜨면 성공
		
	}
	
	@Override
	public int getCount() { //학생 정보가 등록되면 1씩 카운트 하는 함수
		return storage.size();
	}
	
	@Override
	public List<Member> findAll(){
		return storage;
	
	}
	
	@Override
	public Member find(String no) {	
		Member member = null;
		no = "2025-" + no;
		if(no != null) {
			for(Member m : storage) {
				if(m.getNo().equals(no)) {
					member = m;
				}
			}
			
			//forEach는 메소드여서 forEach가 실행되면 find메소드가 stack에서 사라져서 find의 지역변수인 member가 forEach에 접근할 수 없다.
			//forEach는 메소드 호출이므로 stack에 새로운 블록으로 생성되어 실행됨
			//전에 실행중이던 find는 중지하고 forEach로 실행 주도권이 넘어오므로 find의 member는 삭제됨
//			storage.forEach(m -> { //외부에서 생성된 member변수의 scape Iterable 관리
//				if(m.getNo().equals(no)) {
//					member = m;
//				}
//			});
		}//if문
		
		return member;
	}
	
	@Override
	public void update(Member member) {
		int idx = -1;
		for(int i=0; i<storage.size(); i++) {
			Member m = storage.get(i);
			if(m.getNo().equals(member.getNo())) {
				idx = i;
				
				break;
			}
		}
		
		storage.set(idx, member);
	}
	
	@Override
	public void remove(String no) {
		Iterator<Member> ie = storage.iterator();
		while(ie.hasNext()) {
			Member member = ie.next();
			if(member.getNo().equals("2025-"+no)) {
				ie.remove();
				break;
			}
		}
		
// 		int idx = -1;
//		for(int i=0; i<storage.size(); i++) {
//			Member m = storage.get(i);
//			if(m.getNo().equals("2025-"+no)) {
//				idx = i;
//				
//				break;
//			}
//		}
		
//		storage.remove(idx);
	}
}
