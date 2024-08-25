package com.FalakSolution.Trainig.controoler;

import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorReqDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorResDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorUpdateReq;
import com.FalakSolution.Trainig.service.AuthorService.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResDto> addAuthor(@RequestBody @Valid AuthorReqDto authorReqDto) {
        return authorService.addAuthor(authorReqDto);
    }

    @PutMapping("/{author_id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable("author_id") Long authorId, @RequestBody @Valid AuthorUpdateReq authorUpdateReqDto) {
        return authorService.updateAuthor(authorId, authorUpdateReqDto);
    }

    @DeleteMapping("/{author_id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("author_id") Long authorId) {
        return authorService.deleteAuthor(authorId);
    }

    @GetMapping("/{author_id}")
    public ResponseEntity<Object> getAuthorById(@PathVariable("author_id") Long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResDto>> getAllAuthors() {
        return authorService.getAllAuthors();
    }


}
