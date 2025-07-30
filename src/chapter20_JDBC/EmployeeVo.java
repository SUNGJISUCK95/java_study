package chapter20_JDBC;


//[employee 테이블]
//emp_id	char(5)
//emp_name	varchar(4)
//eng_name	varchar(20)
//gender	char(1)
//hire_date	date
//retire_date	date
//dept_id	char(3)
//phone	char(13)
//email	varchar(50)
//salary	int

public class EmployeeVo {
	//-- 1
	String empId; //empId로 카멜케이스 타입으로 사용
	String empName;
	String engName;
	String gender;
	String hireDate;
	String RetireDate;
	String deptId, phone, email; //,로 같은 타입끼리 묶어서도 선언가능
	int rno, salary;
	double bonus;
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getRetireDate() {
		return RetireDate;
	}
	public void setRetireDate(String retireDate) {
		RetireDate = retireDate;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
