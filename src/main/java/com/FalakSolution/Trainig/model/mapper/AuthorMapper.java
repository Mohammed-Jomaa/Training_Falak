//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.FalakSolution.Trainig.model.mapper;

import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorReqDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorResDto;
import com.FalakSolution.Trainig.model.dto.authorDTO.AuthorUpdateReq;
import com.FalakSolution.Trainig.model.entity.authorEntity.Author;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface AuthorMapper {
    Author toEntity(AuthorUpdateReq dto);

    Author toEntity(AuthorReqDto dto);

    AuthorResDto toRespDto(Author entity);
}
