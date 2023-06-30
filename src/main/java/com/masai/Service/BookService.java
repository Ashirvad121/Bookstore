package com.masai.Service;

import java.util.List;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.payload.BookResponse;

public interface BookService {
	public Book registerBook(Book book) throws BookException;
	public Book selectBookByISBN(int isbn)throws BookException;
	
	public List<Book> selectBookByTitle(String title)throws BookException;
	public List<Book> selectBookByAuthor(String author)throws BookException;
	
	public BookResponse getAllBook(int pageNo,int pageSize,String sortBy,String sortDir)throws BookException;
	public Book updateBook(Book book)throws BookException;
	
	public String deleteBook(int isbn)throws BookException;
}
