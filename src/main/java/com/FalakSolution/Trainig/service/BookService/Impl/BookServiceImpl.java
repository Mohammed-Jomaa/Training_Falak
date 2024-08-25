package com.FalakSolution.Trainig.service.BookService.Impl;

import com.FalakSolution.Trainig.model.dto.BookDTO.BookReqDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookResDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookUpdateReq;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorReqDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorResDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorUpdateReq;
import com.FalakSolution.Trainig.model.entity.authorEntity.Author;
import com.FalakSolution.Trainig.model.entity.bookEntity.Book;
import com.FalakSolution.Trainig.model.mapper.AuthorMapper;
import com.FalakSolution.Trainig.model.mapper.BookMapper;
import com.FalakSolution.Trainig.repositry.authorRepo.AuthorRepo;
import com.FalakSolution.Trainig.repositry.bookRepo.BookRepo;
import com.FalakSolution.Trainig.service.BookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResponseEntity<BookResDto> addBook(@RequestBody BookReqDto bookReqDto) {
        try {
            Book book = bookMapper.toEntity(bookReqDto);
            Book createdBook = bookRepo.save(book);
            BookResDto response = bookMapper.toRespDto(createdBook);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Object> updateBook(Long book_id, BookUpdateReq updateReq) {
        if (book_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book ID cannot be null");
        }

        Optional<Book> existingBookOptional = bookRepo.findById(book_id);
        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            // Update book properties here
            existingBook.setTitle(updateReq.getTitle());
            existingBook.setSubtitle(updateReq.getSubtitle());
            existingBook.setDescription(updateReq.getDescription());
            existingBook.setEdition(updateReq.getEdition());
            existingBook.setImageURL(updateReq.getImageURL());
            existingBook.setCategories(updateReq.getCategories());
            existingBook.setPublishing_date(updateReq.getPublishing_date());
            bookRepo.save(existingBook);
            return ResponseEntity.ok(bookMapper.toRespDto(existingBook));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }


    public ResponseEntity<String> deleteBook(Long book_id) {
        try {
            Optional<Book> existingBookOptional = bookRepo.findById(book_id);
            if (existingBookOptional.isPresent()) {
                bookRepo.deleteById(book_id);
                return new ResponseEntity<>("Success delete Book", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error deleting book", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBookById(Long book_id) {
        try {
            Optional<Book> bookOptional = bookRepo.findById(book_id);
            if (bookOptional.isPresent()) {
                Book book = bookOptional.get();
                BookResDto bookResDto = bookMapper.toRespDto(book);
                return new ResponseEntity<>(bookResDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error find book", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Book>> getBooks() {
        try {

            return new ResponseEntity<>(this.bookRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
