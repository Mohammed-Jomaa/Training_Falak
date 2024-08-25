package com.FalakSolution.Trainig.controoler;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookReqDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookResDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookUpdateReq;
import com.FalakSolution.Trainig.model.entity.bookEntity.Book;
import com.FalakSolution.Trainig.service.BookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResDto> addAuthor(@RequestBody @Valid BookReqDto bookReqDto) {
        return this.bookService.addBook(bookReqDto);
    }

    @PutMapping("/{book_id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable("book_id") Long book_id,@RequestBody @Valid BookUpdateReq bookUpdateReq) {
        return bookService.updateBook(book_id,bookUpdateReq);
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<String> deleteBook(@PathVariable("book_id") Long book_id) {
        return bookService.deleteBook(book_id);
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<Object> getBookById(@PathVariable("book_id") Long book_id) {
        return bookService.getBookById(book_id);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return  this.bookService.getBooks();
    }
}
