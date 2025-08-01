package chapter20_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlConnectTest {

	public static void main(String[] args) {
		try {
			//0단계 - 드라이버 다운
			//1단계 - 드라이버 로딩
			//url 형식 - "jdbc:mysql://서버주소:포트번호/DB명?옵션들추가.."
			String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
			String user = "root";
			String password = "mysql1234";
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("---> 1단계 성공");
			
			//2단계 : Statement -- SQL을 실어서 JVM과 DB를 옮겨주는 역할
			Statement stmt = connection.createStatement();
			System.out.println("---> 2단계 성공");
			
			//3단계 : stmt 객체를 이용한 ResultSet 객체 생성
			
			//3단계 방법 (1)
//			String sql = "select emp_id, emp_name, dept_id, salary from employee"
//						 + " where dept_id = 'SYS'";
			
			
			//3단계 방법 (2)
//			StringBuilder sb = new StringBuilder(100);
//			sb.append("select emp_id, emp_name, dept_id, salary from employee");
//			sb.append(" where dept_id = 'SYS'");
//			
//			ResultSet rs = stmt.executeQuery(sb.toString());
			
			
			//3단계 방법 (3)
			//JDK 15이상부터 사용가능 --> 자바스크립트 ``(백틱연산자) : 템플릿 리터럴
			//공백이 들어가도 사용가능, + 필요 없음
//			String sql = """
//						 select emp_id, emp_name, dept_id, salary from employee
			
			
//						 where dept_id = 'SYS'
//						 """;
			
			String sql = """
					     SELECT 
					     	row_number() over() AS rno,
				         	emp_id, 
				         	emp_name, 
				         	dept_id, 
				         	salary,
				         	hire_date 
				         FROM employee 
				         WHERE dept_id = 'SYS'
					     """;
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs != null) {
				System.out.println("---> 3단계 성공");
				
				//4단계 : rs객체에서 데이터 추출
				System.out.println("---> 4단계 성공 : 데이터 추출");
				while(rs.next()) {
					//List<row가 담기는 객체:EmployeeVo>
					System.out.print(rs.getInt(1) + "\t");
					// 또는 System.out.print(rs.getInt("rno"));
					
					System.out.print(rs.getString(2) + "\t");
					System.out.print(rs.getString(3) + "\t");
					System.out.print(rs.getString(4) + "\t");
					System.out.print(rs.getInt(5) + "\t");
					System.out.print(rs.getDate(6) + "\n");
				}
			}
			
			
			
			//5단계 : connection, stmt, rs 객체 종료
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
			
			System.out.println("---> 5단계 성공 : 종료");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
