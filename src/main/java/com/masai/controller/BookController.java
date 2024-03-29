package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.BookService;
import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.payload.BookResponse;
import com.masai.utils.AppConstants;

import jakarta.validation.Valid;

@RestController
public class BookController {
	BookService bser;
	@Autowired
	public BookController(BookService bser) {
		super();
		this.bser = bser;
	}
	@PostMapping("/registerbook")
	public ResponseEntity<Book> registerBook(@Valid @RequestBody Book  book) throws BookException{
		Book regBook= bser.registerBook(book);
		return new ResponseEntity<Book>(regBook,HttpStatus.CREATED);
	}
	@GetMapping("/bookbyisbn/{isbn}")
	public ResponseEntity<Book> findBookByISBN(@PathVariable("isbn") int isbn) throws BookException{
		Book book= bser.selectBookByISBN(isbn);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	@GetMapping("/bookbytitle/{name}")
	public ResponseEntity<List<Book>> selectBookByTitle(@PathVariable("name") String name) throws BookException{
		List<Book> list= bser.selectBookByTitle(name);
		return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
	}
	@GetMapping("/bookbyauthor/{author}")
	public ResponseEntity<List<Book>> selectBookByAuthor(@PathVariable("author") String author) throws BookException{
		List<Book> list= bser.selectBookByAuthor(author);
		return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/allBook")
	public  ResponseEntity<BookResponse> getAllBook(
			@RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
			@RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
			@RequestParam(value="sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
			@RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir
			) throws BookException{
		BookResponse  books= bser.getAllBook(pageNo,pageSize,sortBy,sortDir);
		return new ResponseEntity(books,HttpStatus.OK);
	}
	@PutMapping("/updatebook")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) throws BookException{
		Book updatedBook=bser.updateBook(book);
		return new ResponseEntity<Book>(updatedBook,HttpStatus.OK);
	}
	@DeleteMapping("/deletebook/{isbn}")
	public ResponseEntity<String> deleteBook(@PathVariable("isbn") int isbn) throws BookException{
		String message=bser.deleteBook(isbn);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
