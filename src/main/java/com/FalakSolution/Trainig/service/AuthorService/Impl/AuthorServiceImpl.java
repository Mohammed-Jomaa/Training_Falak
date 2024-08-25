package com.FalakSolution.Trainig.service.AuthorService.Impl;

import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorReqDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorResDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorUpdateReq;
import com.FalakSolution.Trainig.model.entity.authorEntity.Author;
import com.FalakSolution.Trainig.model.mapper.AuthorMapper;
import com.FalakSolution.Trainig.repositry.authorRepo.AuthorRepo;
import com.FalakSolution.Trainig.service.AuthorService.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public ResponseEntity<AuthorResDto> addAuthor(AuthorReqDto authorReqDto) {
        try {
            Author author = authorMapper.toEntity(authorReqDto);
            Author createdAuthor = authorRepo.save(author);
            AuthorResDto response = authorMapper.toRespDto(createdAuthor);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Object> updateAuthor(Long authorId, AuthorUpdateReq updateAuthor) {
        Optional<Author> existingAuthorOptional = authorRepo.findById(authorId);
        if (existingAuthorOptional.isPresent()) {
            Author existingAuthor = existingAuthorOptional.get();
            existingAuthor.setFullName(updateAuthor.getFullName());
            existingAuthor.setTitle(updateAuthor.getTitle());
            existingAuthor.setDob(updateAuthor.getDob());
            existingAuthor.setBio(updateAuthor.getBio());
            authorRepo.save(existingAuthor);
            return ResponseEntity.ok(authorMapper.toRespDto(existingAuthor));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
    }

    public ResponseEntity<String> deleteAuthor(Long authorId) {
        try {
            Optional<Author> existingAuthorOptional = authorRepo.findById(authorId);
            if (existingAuthorOptional.isPresent()) {
                authorRepo.deleteById(authorId);
                return new ResponseEntity<>("Success delete Author", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting author", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getAuthorById(Long authorId) {
        try {
            Optional<Author> authorOptional = authorRepo.findById(authorId);
            if (authorOptional.isPresent()) {
                Author author = authorOptional.get();
                AuthorResDto authorResDto = authorMapper.toRespDto(author);
                return new ResponseEntity<>(authorResDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Error find author", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<AuthorResDto>> getAllAuthors() {
        try {
            List<Author> authors = authorRepo.findAll();
            List<AuthorResDto> authorsResDto = authors.stream()
                    .map(authorMapper::toRespDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(authorsResDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
