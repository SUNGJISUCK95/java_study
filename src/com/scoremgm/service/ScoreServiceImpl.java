package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.Member;
import com.scoremgm.repository.ScoreRepository;
import com.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService{
	//implements시 Override 필수
	Scanner scan;
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();
	
	public ScoreServiceImpl() {
		
	}
	
	public ScoreServiceImpl(ScoreMgmSystem sms) { //ScoreMgmSystem의 전체 주소값을 매개변수로 받아옴
		this.sms = sms;
		this.scan = sms.scan;
	}
	
	/**
	 * 학생 정보 저장소(storage)의 갯수 가져오기
	 */
	@Override
	public int getCount() {
		return repository.getCount();
	}
	
	/**	
	 * 학생 등록
	 */
	@Override
	public void register() {
		List memberInfo = createMemberInfo();
//		memb1erInfo.forEach(System.out::println);
		
		//Member 생성
		Member member = new Member();
		//Member의 필드에 각 값들 set으로 넘김
		member.setNo((String)memberInfo.get(0)); 
		member.setName((String)memberInfo.get(1));		
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		//저장소 등록을 위한 Repository 호출
		if(repository.insert(member)) {
			//성공
			System.out.println("등록 완료");
		}else {
			//실패
			System.out.println("등록 실패");
		}
		
		//메뉴 호출
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 학번 정보 임시 저장 객체 생성
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학", "자바", "음악"};
		List memberInfo = new ArrayList();
		
		String no = "2025-";
		Random rd = new Random();
		no += rd.nextInt(1000, 9999); //nextInt는 지정 범위에서 숫자를 랜덤으로 뽑아준다.
		memberInfo.add(no);
		
		for(int i=0; i<labels.length; i++) {
			if(i>=2) {
				System.out.println(labels[i] + ">");
				int str = scan.nextInt();
				memberInfo.add(str);
			} else {
				//i = 0, 1 일때
				System.out.println(labels[i] + ">");
				String str = scan.next();
				memberInfo.add(str);
			}
		}
		
		return memberInfo;
	}
	
	
	@Override
	public void list() {
		if(getCount() != 0) {			
			List<Member> list = repository.findAll();
			System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
			
			list.forEach((member) -> {
				System.out.print(member.getNo() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			});
			//또는
	//		for(Member member: list) {
	//			System.out.print(member.getNo() + "\t");
	//			System.out.print(member.getName() + "\t");
	//			System.out.print(member.getDepartment() + "\t");
	//			System.out.print(member.getKor() + "\t");
	//			System.out.print(member.getEng() + "\t");
	//			System.out.print(member.getMath() + "\n");
	//		}
		}else {
			System.out.println("등록된 학생이 없습니다.");
			sms.showMenu();
			sms.selectMenu();
		}
	} 
	
	@Override
	public void search(){
	
	} 
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void delete(){
		
	}
	@Override
	public void eixt(){
		System.out.println("프로그램 종료");
		System.out.println(0);
	}
}
