package com.bookmgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bookmgm.app.BookManagementApplication;
import com.bookmgm.model.Book;
import com.bookmgm.repository.AladinBookRepository;
import com.bookmgm.repository.InMemoryBookRepository;
import com.bookmgm.repository.Yes24BookRepository;

import db.GenericRepositoryInterface;

public class DefaultBookService implements BookService {
	BookManagementApplication bma;	 
	GenericRepositoryInterface<Book> repository; //선언은 인터페이스
	public DefaultBookService() {
		
	}
	
	public DefaultBookService(BookManagementApplication bma) { //BookManagementApplication 클래스의 전체 주소값
		this.bma = bma; //전역 변수로 지정해서 BookManagementApplication의 기능들 편하게 사용
//		repository = new InMemoryBookRepository(); //생성자는 자식 클래스로
		selectRepository();
	}
	
	/**
	 * 도서관 선택
	 */
	public void selectRepository() {
		System.out.println("------------------------------");
		System.out.println("1. 교육센터 2. 알라딘 3. 예스24");
		System.out.println("------------------------------");
		System.out.print("도서관 선택> ");
		int rno = bma.scan.nextInt();
		//인터페이스를 이용하면 InMemoryBookRepository만 만들었지만 이름만 바꿔서 복사해서 사용하여 간편하게 여러 클래스로 유지보수가 가능하다.
		if(rno == 1) {
			repository = new InMemoryBookRepository(1);
		}else if(rno == 2) {
			repository = new InMemoryBookRepository(2);
		}else if(rno == 3) {
			repository = new InMemoryBookRepository(3);
		}
	}
	
	@Override
	public void register() {
//	[도서 등록]
//	도서명: 자바프로그래밍
//	저자: 서민구
//	가격: 30000
//	✅ 도서가 등록되었습니다.
		List bookInfo = createBook();
//		System.out.println(book.getId());
//		System.out.println(book.getName());
//		System.out.println(book.getAuthor());
//		System.out.println(book.getPrice());
		Book book = new Book();
		
		book.setBtitle((String)bookInfo.get(0));
		book.setAuthor((String)bookInfo.get(1));
		book.setPrice((int)bookInfo.get(2));
		book.setIsbn((int)bookInfo.get(3));
	
		if(repository.insert(book) == 1) {
			//등록 성공
			System.out.println("도서 등록 성공");
		}else {
			//등록 실패
			System.out.println("도서 등록 실패");
		}
		
		bma.showMenu();
	}
	
	/**
	 * 도서 생성
	 * @return
	 */
	public List createBook() {
//		[도서 등록]
//		도서명: 자바프로그래밍
//		저자: 서민구
//		가격: 30000
//		✅ 도서가 등록되었습니다.
			List bookInfo = new ArrayList();
			
			Book book = new Book();
			Random rd = new Random();
			
			
//			bookInfo.add(String.valueOf(id)); //String으로 형변환
			
			System.out.println("[도서 등록]");
			System.out.print("도서명> ");
			String btitle = bma.scan.next();
			bookInfo.add(btitle);
			
			System.out.print("저자> ");
			String author = bma.scan.next();
			bookInfo.add(author);
			
			System.out.print("가격> ");
			int price = bma.scan.nextInt();
			bookInfo.add(price);
			
//			System.out.print("도서번호> ");
//			int isbn = bma.scan.nextInt();
			int isbn = rd.nextInt(1000, 9999);
			bookInfo.add(isbn);
			
			return bookInfo;
	}
	
	/**
	 * 도서 생성
	 * @param
	 * 도서 수정시 도정 정보를 일부 수정하여 반환
	 */
	public Book createBook(Book book) {			
			System.out.print("도서명> ");
			String btitle = bma.scan.next();
			book.setBtitle(btitle);
			
			System.out.print("저자> ");
			String author = bma.scan.next();
			book.setAuthor(author);
			
			System.out.print("가격> ");
			int price = bma.scan.nextInt();
			book.setPrice(price);
			
//			System.out.print("도서번호> ");
//			int isbn = bma.scan.nextInt();
//			book.setIsbn(isbn);
			
			return book;
	}
	
	@Override
	public void list() {
		if(getCount() != 0) {
			List<Book> library = repository.findAll();
			System.out.println("id\t\t도서명\t저자\t가격\t도서번호");
			
			library.forEach((booklist) -> {
				System.out.print("[" + booklist.getBid() + "]\t\t");
				System.out.print(booklist.getBtitle() + "\t");
				System.out.print(booklist.getAuthor() + "\t");				
				System.out.print(booklist.getPrice() + "\t");
				System.out.print(booklist.getIsbn() + "\n");
			});
		}else {
			System.out.println("등록된 도서가 없습니다. 도서를 등록해 주세요.");
		}
		bma.showMenu();
	}
	
	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.println("도서번호> ");
			String bid = bma.scan.next();
			Book book = repository.find(bid);
			System.out.println("id\t도서명\t저자\t가격\t도서번호");
			if(book != null) {
				System.out.print("[" + book.getBid() + "]\t\t");
				System.out.print(book.getBtitle() + "\t");
				System.out.print(book.getAuthor() + "\t");				
				System.out.print(book.getPrice() + "\t");
				System.out.print(book.getIsbn() + "\n");
			}else {
				System.out.println("검색 도서가 없습ㄴ다.");
			}
		}else {
			System.out.println("등록된 도서가 존재하지 않습니다. 도서를 등록해 주세요.");
		}
		bma.showMenu();
	}
	
	/**
	 * 도서 출력 - 검색, 수정 시 결과 출력
	 * @param
	 */
	public void printBook(Book book) {
		System.out.println("id\t도서명\t저자\t가격\t도서번호");
		System.out.println("------------------------------");
		System.out.print(book.getBid() + "\t");
		System.out.print(book.getBtitle() + "\t");
		System.out.print(book.getAuthor() + "\t");
		System.out.print(book.getPrice() + "\t");
		System.out.print(book.getIsbn() + "\n");
	}
	
	/**
	 * 도서 수정
	 */
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.println("도서번호> ");
			String bid = bma.scan.next();
			Book book = repository.find(bid);
			if(book != null) {
				repository.update(createBook(book));
				//오버로딩으로 만든 createBook 메소드에서 처리 후 받은 값으로 update
				System.out.println("도서 수정 완료");
				
				System.out.println("수정결과");
				System.out.println("------------------------------");
				printBook(book);
//				System.out.println("id\t\t도서명\t저자\t가격");
//				System.out.println("------------------------------");
//				System.out.print(book.getId() + "\t");
//				System.out.print(book.getName() + "\t");
//				System.out.print(book.getAuthor() + "\t");
//				System.out.print(book.getPrice() + "\t");
				System.out.println("------------------------------");
			}else {
				System.out.println("검색한 도서가 존재하지 않습니다.");
			}
		}else {
			System.out.println("등록된 도서가 존재하지 않습니다. 도서를 등록해 주세요.");
		}
		bma.showMenu();
		bma.selectMenu();
	}
	
	@Override
	public void delete() {
		if(getCount() != 0) {
			System.out.println("도서번호> ");
			String bid = bma.scan.next();
			Book book = repository.find(bid);
	
			if(book != null) {
				repository.remove(book.getBid());
//				repository.remove(book);
				System.out.println("도서가 삭제 되었습니다.");
			}else {
				System.out.println("삭제할 도서가 존재하지 않습니다.");
			}
		}else {
			System.out.println("등록된 도서가 존재하지 않습니다. 도서를 등록해 주세요.");
		}
		bma.showMenu();
	}
	
	@Override
	public void eixt() {
		System.out.println("프로그램 종료");
		repository.close();
		System.exit(0);
	}
	
	@Override
	public int getCount() {
		return repository.getCount(); //library ArrayList의 사이즈
	}
}
