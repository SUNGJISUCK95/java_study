package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	//Field
	
	//--1
	//url 형식 - "jdbc:mysql://서버주소:포트번호/DB명?옵션들추가.."
	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection; //접근제한자가 선언이 안되면 같은 패키지에서만 사용이 가능하다
	protected Statement stmt; //protected로 자식이 접근가능하도록 선언
	protected ResultSet rs;
	protected PreparedStatement pstmt;
	
	//Constructor
	
	//--2
	protected DBConn() { //protected : 상속한 자식들만 호출 가능
		try {			
			//1단계 - 드라이버 로딩			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("---> 1단계 성공");			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Method
	
	//--3
	//Statement 생성
	public Statement getStatement() {
		try {
			//2단계 : Statement -- SQL을 실어서 JVM과 DB를 옮겨주는 역할
			stmt = connection.createStatement();
			System.out.println("---> Statement 2단계 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	//PreparedStatement 생성
	public Statement getPreparedStatement(String sql) {
		try {
			//2단계 : PreparedStatement -- SQL을 실어서 JVM과 DB를 옮겨주는 역할
			pstmt = connection.prepareStatement(sql);
			System.out.println("---> PreparedStatement 2단계 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	//--4
	//Close 생성
	public void close() {
		try {
			//5단계 : connection, stmt, rs 객체 종료
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
