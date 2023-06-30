package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.payload.BookResponse;
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
	public BookResponse getAllBook(int pageNo,int pageSize,String sortBy,String sortDir) throws BookException{
		// TODO Auto-generated method stub
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending()
				:Sort.by(sortBy).descending();
		Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
		Page<Book> books=brepo.findAll(pageable);
		List<Book> listOfBook=books.getContent();
		BookResponse bookResponse=new BookResponse();
		bookResponse.setContents(listOfBook);
		bookResponse.setPageNo(books.getNumber());
		bookResponse.setPageSize(books.getSize());
		bookResponse.setTotalElements(books.getTotalElements());
		bookResponse.setTotalpages(books.getTotalPages());
		bookResponse.setLast(books.isLast());
		return bookResponse;
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
