package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.MemberVo;
import com.scoremgm.repository.ScoreRepositoryImpl;

import db.GenericRepositoryInterface;

public class ScoreServiceImpl implements ScoreService{
	//implements시 Override 필수
	Scanner scan;
	ScoreMgmSystem sms;
	GenericRepositoryInterface<MemberVo> repository = new ScoreRepositoryImpl();
	
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
		MemberVo member = new MemberVo();
		//Member의 필드에 각 값들 set으로 넘김
//		member.setMid((String)memberInfo.get(0)); 
		member.setName((String)memberInfo.get(0));		
		member.setDepartment((String)memberInfo.get(1));
		member.setKor((int)memberInfo.get(2));
		member.setEng((int)memberInfo.get(3));
		member.setMath((int)memberInfo.get(4));
		
		//저장소 등록을 위한 Repository 호출
		if(repository.insert(member) == 1) {
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
	 * @param no 학번
	 * @return List
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		
		for(int i=0; i<labels.length; i++) {
			if(i>=2) {
				System.out.print(labels[i] + ">");
				int str = scan.nextInt();
				memberInfo.add(str);
			} else {
				//i = 0, 1 일때
				System.out.print(labels[i] + ">");
				String str = scan.next();
				memberInfo.add(str);
			}
		}
		
		return memberInfo;
	}
	
	
	public List createMemberInfo(MemberVo member) {
		String[] labels = {"국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		
//		System.out.println("학번 : " + member.getMid() + "," + "학생명 : " + member.getName());
		
		for(int i=0; i<labels.length; i++) {
			System.out.println(labels[i] + ">");
			int str = scan.nextInt();
			memberInfo.add(str); 
		}
		
		return memberInfo;
	}
	
	@Override
	public void list() {
		if(getCount() != 0) {			
			List<MemberVo> list = repository.findAll();
			System.out.println("번호\t학번\t이름\t전공\t국어\t영어\t수학");
			
			list.forEach((member) -> {
				System.out.print(member.getRno() + "\t");
				System.out.print(member.getMid() + "\t");
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
			sms.showMenu();
			sms.selectMenu();
		}else {
			System.out.println("등록된 학생이 없습니다.");
			sms.showMenu();
			sms.selectMenu();
		}
	} 
	
	/**
	 * 학생 검색 : 학번 기준
	 */
	@Override
	public void search(){
		if(getCount() != 0) {
			System.out.println("학번> ");
			String mid = scan.next();
			MemberVo member = repository.find(mid); 
			//Member에서 특정 학번으로 학생정보 가져오기
			//List는 등록 된 전체 학생이니 Member에서 가져옴
			
			if(member != null) { //member 자체는 주소값이 있으므로 데이터로 확인		
				System.out.println("검색결과");
				System.out.println("------------------------------");
				System.out.println("학번\t이름\t전공\t국어\t영어\t수학");
				System.out.println("------------------------------");
				System.out.print(member.getMid() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
				System.out.println("------------------------------");
				sms.showMenu();
				sms.selectMenu();
			}
			else {
				System.out.println("학생 정보 없음");
				search();
			}			
		}else {
			System.out.println("등록된 학생이 없습니다.");
			sms.showMenu();
			sms.selectMenu();
		}
	} 
	
	/**
	 * 학생 수정
	 */
	@Override
	public void update(){		
		if(getCount() != 0) {
			System.out.println("학번> ");
			String no = scan.next();
			MemberVo member = repository.find(no); //학생 정보 - old
			
			if(member != null) {	
				//수정할 학생 정보 입력 (학번 제외)
				List memberInfo = createMemberInfo(member);
				member.setKor((int)memberInfo.get(0));
				member.setEng((int)memberInfo.get(1));
				member.setMath((int)memberInfo.get(2));
				
				//storage에 member 업데이트
				repository.update(member);
				
				
				System.out.println("수정결과");
				System.out.println("------------------------------");
				System.out.println("학번\t이름\t전공\t국어\t영어\t수학");
				System.out.println("------------------------------");
				System.out.print(member.getMid() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
				System.out.println("------------------------------");
				sms.showMenu();
				sms.selectMenu();
			}else {
				System.out.println("학생 정보 없음");
				update();
			}			
		}else {
			System.out.println("등록된 학생이 없습니다.");
			sms.showMenu();
			sms.selectMenu();
		}
	}
	
	/**
	 * 학생 삭제
	 */
	@Override
	public void delete(){
		List<MemberVo> list = repository.findAll();
		if(getCount() != 0) {
			System.out.println("학번> ");
			String mid = scan.next();
			MemberVo member = repository.find(mid); 
			
			if(member != null) {
				//정말로 삭제 진행 여부 확인
				System.out.println("정말로 삭제하시겠습니까?(y:삭제, 아무키:취소) > ");
				if(scan.next().equals("y")){
					repository.remove(mid);

					System.out.println("삭제결과");
					System.out.println("------------------------------");
					System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
					System.out.println("------------------------------");
					list.forEach((remove_member) -> {
						System.out.print(remove_member.getMid() + "\t");
						System.out.print(remove_member.getName() + "\t");
						System.out.print(remove_member.getDepartment() + "\t");
						System.out.print(remove_member.getKor() + "\t");
						System.out.print(remove_member.getEng() + "\t");
						System.out.print(remove_member.getMath() + "\n");
					});
					System.out.println("------------------------------");					
					
					sms.showMenu();
					sms.selectMenu();
				} else {
					sms.showMenu();
					sms.selectMenu();
				}
			}else {
				System.out.println("학생 정보 없음");
				delete();
			}			
		}else {
			System.out.println("등록된 학생이 없습니다.");
			sms.showMenu();
			sms.selectMenu();
		}
	}
	
	@Override
	public void eixt(){		
		System.out.println("프로그램 종료");
		System.exit(0);
	}
}
