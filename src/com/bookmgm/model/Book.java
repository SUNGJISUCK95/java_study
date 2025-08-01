package com.bookmgm.model;

import java.util.List;
import java.util.Scanner;

//bid	char(4)
//btitle	varchar(20)
//author	varchar(10)
//price	int
//isbn	int
//bdate	datetime
public class Book {
	//Field
	private int rno;
	private String bid;
	private String btitle;
	private String author;
	private int price;
	private int isbn;
	private String bdate;
	



	//Constructor
	public Book() {
		
	}
	
	
	
	//Method
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}	
	public void setPrice(int price) {
		this.price = price;
	}	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
}
