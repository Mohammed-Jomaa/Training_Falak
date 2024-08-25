package com.FalakSolution.Trainig.model.mapper;

import com.FalakSolution.Trainig.model.dto.BookDTO.BookReqDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookResDto;
import com.FalakSolution.Trainig.model.dto.BookDTO.BookUpdateReq;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorReqDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorResDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorUpdateReq;
import com.FalakSolution.Trainig.model.entity.authorEntity.Author;
import com.FalakSolution.Trainig.model.entity.bookEntity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface BookMapper {
    Book toEntity(BookUpdateReq dto);

    Book toEntity(BookReqDto dto);

    BookResDto toRespDto(Book entity);
}
