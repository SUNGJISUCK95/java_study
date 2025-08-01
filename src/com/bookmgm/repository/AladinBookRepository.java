package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;

import db.DBConn;
import db.GenericRepositoryInterface;

public class AladinBookRepository extends DBConn
								  implements GenericRepositoryInterface<Book>{
	
//	List<Book> library = new ArrayList<Book>(); 
	//Book 정보가 담길 리스트(배열) 생성
	
	public AladinBookRepository() {
		super();
		System.out.println("알라딘 도서관 입장");
	}
	
	@Override
	public int insert(Book book) {
		int rows = 0;
		
		String sql = """
				 INSERT INTO book_aladin(btitle, author, price, isbn, bdate) 
				             values (?, ?, ?, ?, now())
				 """;
	
		try {		     	
			getPreparedStatement(sql);
			pstmt.setString(1, book.getBtitle());
			pstmt.setString(2, book.getAuthor());	
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getIsbn());
			rows = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
	@Override
	public List<Book> findAll(){
		List<Book> list = new ArrayList<Book>();
		String sql = """
				 SELECT 
				 	row_number() over(),
				 	bid, btitle, author, price, isbn, bdate 
				 FROM  book_aladin
				 """;
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setRno(rs.getInt(1));
				book.setBid(rs.getString(2));
				book.setBtitle(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setIsbn(rs.getInt(6));
				book.setBdate(rs.getString(7));
				
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Book find(String bid) {
		Book book = null;
		
		String sql = """
				 SELECT	bid, btitle, author, price, isbn, bdate 
				 FROM book_aladin
				 WHERE bid = ?
				 """;
	
		try {		     	
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBid(rs.getString(1));
				book.setBtitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	@Override
	public int update(Book book) {
		int rows = 0;
		
		String sql = """
				 UPDATE	book_aladin
				 SET btitle = ?, author = ?, price = ?
				 WHERE bid = ?
				 """;
	
		try {		     	
			getPreparedStatement(sql);
			pstmt.setString(1, book.getBtitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBid());
			
			rows = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@Override
	public int remove(String bid) {
		int rows = 0;
		
		String sql = """
				 DELETE	FROM book_aladin
				 WHERE bid = ?
				 """;
	
		try {		     	
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			
			rows = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
//	
//	public void remove(Book book) {
//		Iterator<Book> ie = library.iterator();
//		while(ie.hasNext()) {
//			Book b = ie.next();
//			if(b == book) {
//				ie.remove();
//				break;
//			}
//		}
//	}
	
	@Override
	public int getCount() {
		int rows = 0;
		String sql = "SELECT count(*) FROM book_aladin";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
}
