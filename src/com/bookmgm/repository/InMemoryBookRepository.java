package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;
import com.scoremgm.model.Member;

public class InMemoryBookRepository implements BookRepository{
	List<Book> library = new ArrayList<Book>(); 
	//Book 정보가 담길 리스트(배열) 생성
	
	public InMemoryBookRepository() {
		System.out.println("교육센터 도서관 입장");
	}
	
	@Override
	public boolean insert(Book book) {
		if(book != null) {
			return library.add(book);
		}else {
			return false;
		}
	}
	
	@Override
	public List<Book> selectAll(){
		return library;
	}
	
	@Override
	public Book select(String id) {
		Book book = null;
		
		for(Book b : library) {
			if(b.getId().equals(id)) {
				book = b;
				break;
			}
		}
		
		return book;
	}
	
	@Override
	public void update(Book book) {
		int idx = -1;
		for(int i=0; i<library.size(); i++) {
			Book b = library.get(i);
			if(b.getId().equals(book.getId())){
				idx = i;
				break;
			}
		}
		
		library.set(idx, book);
	}
	
	@Override
	public void remove(String id) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book book = ie.next();
			if(book.getId().equals(id)) {
				ie.remove();
				break;
			}
		}
	}
	
	public void remove(Book book) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book b = ie.next();
			if(b == book) {
				ie.remove();
				break;
			}
		}
	}
	
	@Override
	public int getCount() {
		return library.size();
	}
}
