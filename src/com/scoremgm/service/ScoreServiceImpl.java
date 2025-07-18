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
	 * @param no 학번
	 * @return List
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};
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
	
	
	public List createMemberInfo(Member member) {
		String[] labels = {"국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		
		System.out.println("학번 : " + member.getNo() + "," + "학생명 : " + member.getName());
		
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
			System.out.println("학번(끝4자리)> ");
			String no = scan.next();
			Member member = repository.find(no); 
			//Member에서 특정 학번으로 학생정보 가져오기
			//List는 등록 된 전체 학생이니 Member에서 가져옴
			
			if(member != null) {		
				System.out.println("검색결과");
				System.out.println("------------------------------");
				System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
				System.out.println("------------------------------");
				System.out.print(member.getNo() + "\t");
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
			System.out.println("학번(끝4자리)> ");
			String no = scan.next();
			Member member = repository.find(no); 
			if(member != null) {	
				List memberInfo = createMemberInfo(member);
				member.setKor((int)memberInfo.get(0));
				member.setEng((int)memberInfo.get(1));
				member.setMath((int)memberInfo.get(2));
				
				//storage에 member 업데이트
				repository.update(member);
				
				
				System.out.println("수정결과");
				System.out.println("------------------------------");
				System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
				System.out.println("------------------------------");
				System.out.print(member.getNo() + "\t");
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
		List<Member> list = repository.findAll();
		if(getCount() != 0) {
			System.out.println("학번(끝4자리)> ");
			String no = scan.next();
			Member member = repository.find(no); 
			if(member != null) {
				//정말로 삭제 진행 여부 확인
				System.out.println("정말로 삭제하시겠습니까?(y:삭제, 아무키:취소) > ");
				if(scan.next().equals("y")){
					repository.remove(no);

					System.out.println("삭제결과");
					System.out.println("------------------------------");
					System.out.println("학번\t\t이름\t전공\t국어\t영어\t수학");
					System.out.println("------------------------------");
					list.forEach((remove_member) -> {
						System.out.print(remove_member.getNo() + "\t");
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
