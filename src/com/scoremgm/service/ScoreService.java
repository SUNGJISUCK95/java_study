package com.scoremgm.service;

//1. 학생 등록
//2. 학생 목록 조회
//3. 학생 성적 검색
//4. 성적 수정
//5. 학생 삭제
//6. 종료
public interface ScoreService {
	public void register(); //C
	public void list(); //R
	public void search(); //R
	public void update(); //U
	public void delete(); //D
	public void eixt();
	int getCount();
}
