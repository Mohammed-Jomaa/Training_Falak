package com.FalakSolution.Trainig.service.BookService;

import com.FalakSolution.Trainig.model.dto.BookDTO.BookReqDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookResDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookUpdateReq;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorReqDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorResDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorUpdateReq;
import com.FalakSolution.Trainig.model.entity.bookEntity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public ResponseEntity<BookResDto> addBook(BookReqDto bookReqDto) ;
    public ResponseEntity<Object> updateBook(Long book_id,BookUpdateReq book) ;
    public ResponseEntity<String> deleteBook(Long book_id) ;
    public ResponseEntity<Object> getBookById(Long book_id) ;
    public ResponseEntity<List<Book>> getBooks() ;

}
