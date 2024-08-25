package com.FalakSolution.Trainig.repositry.authorRepo;

import com.FalakSolution.Trainig.model.entity.authorEntity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
