package com.masai.payload;

import java.util.List;

import com.masai.model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
	
	private List<Book> contents;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalpages;
	private boolean last; 
	
}
