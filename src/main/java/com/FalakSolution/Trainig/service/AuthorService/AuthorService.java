package com.FalakSolution.Trainig.service.AuthorService;

import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorReqDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorResDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorUpdateReq;
import com.FalakSolution.Trainig.model.entity.authorEntity.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    ResponseEntity<AuthorResDto> addAuthor(AuthorReqDto authorReqDto);

    ResponseEntity<Object> updateAuthor( Long authorId, AuthorUpdateReq authorUpdateReq);

    ResponseEntity<String> deleteAuthor(Long authorId);

    ResponseEntity<Object> getAuthorById(Long authorId);

    ResponseEntity<List<AuthorResDto>> getAllAuthors();
}
