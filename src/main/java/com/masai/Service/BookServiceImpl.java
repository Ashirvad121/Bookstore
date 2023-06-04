package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.repo.BookRepo;


@Service
public class BookServiceImpl implements BookService{
	
	
	BookRepo brepo;
	
	
	@Autowired
	public BookServiceImpl( BookRepo brepo) {
		super();
		this.brepo = brepo;
	}

	@Override
	public Book registerBook(Book book) throws BookException{
		// TODO Auto-generated method stub
		if(book==null) {
			throw new BookException("please enter correct book details");
		}
		else {
			return brepo.save(book);
		}
		
		
	}

	@Override
	public Book selectBookByISBN(int isbn) throws BookException{
		// TODO Auto-generated method stub
		Optional<Book> opt= brepo.findById(isbn);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new BookException("No book with this isbn");
	}

	@Override
	public List<Book> selectBookByTitle(String title) throws BookException{
		// TODO Auto-generated method stub
		List<Book> list=brepo.findByTitle(title);
		if(list.size()==0) {
			throw new BookException("No book with this title");
		}
		else {
			return list;
		}
	}

	
	@Override
	public List<Book> selectBookByAuthor(String author) throws BookException{
		// TODO Auto-generated method stub
		List<Book> list= brepo.getBookByAuthor(author);
		if(list.size()==0) {
			throw new BookException("No book by "+author);
		}
		return list;
	}

	@Override
	public List<Book> getAllBook() throws BookException{
		// TODO Auto-generated method stub
		List<Book> list=brepo.findAll();
		if(list.size()==0) {
			throw new BookException("No book available");
		}
		else {
			return list;
		}
	}

	@Override
	public Book updateBook(Book book)throws BookException {
		// TODO Auto-generated method stub
		int isbn= book.getIsbn();
		Optional<Book> opt= brepo.findById(isbn);
		if(opt.isPresent()) {	
			return brepo.save(book);
		}else {
			throw new BookException("No book with this isbn");
		}
	}

	@Override
	public String deleteBook(int isbn)throws BookException {
		// TODO Auto-generated method stub
		Optional<Book> opt=brepo.findById(isbn);
		if(opt.isEmpty()) {
			throw new BookException("No book with this isbn");
		}else {
			brepo.delete(opt.get());
			return "Book deleted";
		}
	}

}
