package org.example.repository;

import org.example.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
