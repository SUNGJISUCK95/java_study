package chapter20_JDBC;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class DepartmentDao extends DBConn{
	//Field
	
		//-- 3
		//url 형식 - "jdbc:mysql://서버주소:포트번호/DB명?옵션들추가.."
//		private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
//		private String user = "root";
//		private String password = "mysql1234";
//		
//		Connection connection;
//		Statement stmt;
//		ResultSet rs;
		
		//Constructor
		
		//-- 2
		public DepartmentDao() {
			//-- 4
//			try {			
//				//1단계 - 드라이버 로딩			
//				connection = DriverManager.getConnection(url, user, password);
//				System.out.println("---> 1단계 성공");			
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
			super();
			
		}
		
		//Method
		//CRUD 기능에 따라 메소드 생성
		
		//-- 6
//		public void getStatement() {
//			try {
//				//2단계 : Statement -- SQL을 실어서 JVM과 DB를 옮겨주는 역할
//				stmt = connection.createStatement();
//				System.out.println("---> 2단계 성공");
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
		public boolean insert(DepartmentVo department) {
			boolean result = false;
			try {
				//PreparedStatement 방법
				String sql = """
							 INSERT INTO department(dept_id, dept_name, unit_id, start_date)
							 			 values(?, ?, ?, curdate());
							 """;
				getPreparedStatement(sql);
				pstmt.setString(1, department.getDeptId());
				pstmt.setString(2, department.getDeptName());
				pstmt.setString(3, department.getUnitId());
				
				int rows = pstmt.executeUpdate();
				if(rows == 1) {
					result = true;
				}
				
				//Statement 방법
//				getStatement();
//				if(stmt != null) {
//					StringBuilder sb = new StringBuilder();
//					sb.append("INSERT INTO department(dept_id, dept_name, unit_id, start_date)");
//					sb.append(" values(\'");
//					sb.append(department.getDeptId() + "\',\'");
//					sb.append(department.getDeptName() + "\',\'");
//					sb.append(department.getUnitId() + "\',");
//					sb.append(" curdate() )");
//					
//					int resultRow = stmt.executeUpdate(sb.toString());
//					if(resultRow == 1) {
//						result = true;
//					}
//					String sql = """
//								 INSERT INTO department(dept_id, dept_name, unit_id, start_date)
//								 			 values(department.get)
//								 """;
//					int resultRow = stmt.executeUpdate(sql);
//					
//					System.out.println("rows --> " + resultRow);
//					
//				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
		/**
		 * 전체 리스트
		 * @return
		 */
		//-- 8
		public List<DepartmentVo> getList() {
			List<DepartmentVo> list = new ArrayList<DepartmentVo>();
			String sql = """
						 SELECT
						    dept_id,
						 	dept_name,
						 	unit_id,
						 	start_date
						 From department
						 """;
			try {
				//3단계 : stmt 객체를 이용한 ResultSet 객체 생성			
				getStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs != null) {
					while(rs.next()) {
						//rs 객체의 1 row --> EmployeeVo 저장
						DepartmentVo department = new DepartmentVo();
						department.setDeptId(rs.getString(1));
						department.setDeptName(rs.getString(2));
						department.setUnitId(rs.getString(3));
						department.setStartDate(rs.getString(4));
						
						list.add(department);
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
//		public void close() {
//			try {
//				//5단계 : connection, stmt, rs 객체 종료
//				if(rs != null) rs.close();
//				if(stmt != null) stmt.close();
//				if(connection != null) connection.close();
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
}
