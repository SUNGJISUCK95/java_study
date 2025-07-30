package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class EmployeeDao extends DBConn{ //DB 'CURD'의 집합체
	//Field
	
	//-- 3
	//url 형식 - "jdbc:mysql://서버주소:포트번호/DB명?옵션들추가.."
	
	//DBConn에 있으므로 주석처리
//	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
//	private String user = "root";
//	private String password = "mysql1234";
//	
//	Connection connection;
//	Statement stmt;
//	ResultSet rs;
	
	//Constructor
	
	//-- 2
	public EmployeeDao() {
		//-- 4
		//DBConn에 있으므로 주석처리
//		try {			
//			//1단계 - 드라이버 로딩			
//			connection = DriverManager.getConnection(url, user, password);
//			System.out.println("---> 1단계 성공");			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		super();
		
	}
	
	//Method
	//CRUD 기능에 따라 메소드 생성
	
	//-- 6
	//DBConn에 있으므로 주석처리
//	public void getStatement() {
//		try {
//			//2단계 : Statement -- SQL을 실어서 JVM과 DB를 옮겨주는 역할
//			stmt = connection.createStatement();
//			System.out.println("---> 2단계 성공");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//-- 8
	public List<EmployeeVo> getList() {
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		String sql = """
					 SELECT
					    emp_id,
					 	emp_name,
					 	hire_date,
					 	salary
					 From employee
					 """;
		try {
			//3단계 : stmt 객체를 이용한 ResultSet 객체 생성
			//부모인 DBConn의 getStatement 호출 //DBConn에서 protected로 접근제한자를 선언해서 전역으로 사용가능
			getStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs != null) {
				while(rs.next()) {
					//rs 객체의 1 row --> EmployeeVo 저장
					EmployeeVo employee = new EmployeeVo();
					employee.setEmpId(rs.getString(1));
					employee.setEmpName(rs.getString(2));
					employee.setHireDate(rs.getString(3));
					employee.setSalary(rs.getInt(4));
					
					list.add(employee);
				}
				System.out.println("---> 3단계 성공");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		close();
		
		return list;
	}
	
	//-- 10
//	public void close() {
//		try {
//			//5단계 : connection, stmt, rs 객체 종료
//			if(rs != null) rs.close();
//			if(stmt != null) stmt.close();
//			if(connection != null) connection.close();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
