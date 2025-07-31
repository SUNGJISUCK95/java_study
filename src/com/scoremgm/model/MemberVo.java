package com.scoremgm.model;

//이름: 홍길동
//학번: 20250101
//전공: 컴퓨터공학
//국어 점수: 90
//영어 점수: 85
//수학 점수: 95
public class MemberVo {
	//Field
	private int rno;
	private String mid;
	private String name;
	private String department;
	private int kor;
	private int eng;
	private int math;
	private String mdate;
	//private면 무조건 get, set 생성
	
	
	//Constructor
	public MemberVo() {
		
	}
	
	//Method
	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getName() {
		return name;
	}	

	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
}	
