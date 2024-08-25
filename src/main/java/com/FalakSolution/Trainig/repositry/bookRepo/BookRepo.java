package com.FalakSolution.Trainig.repositry.bookRepo;

import com.FalakSolution.Trainig.model.entity.bookEntity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
