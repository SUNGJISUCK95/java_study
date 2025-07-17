package com.scoremgm.model;

//이름: 홍길동
//학번: 20250101
//전공: 컴퓨터공학
//국어 점수: 90
//영어 점수: 85
//수학 점수: 95
public class Member {
	//Field
	private String no;
	private String name;
	private String department;
	private int kor;
	private int eng;
	private int math;
	//private면 무조건 get, set 생성
	
	//Constructor
	public Member() {
		
	}
	
	//Method
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
