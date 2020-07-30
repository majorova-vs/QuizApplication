package org.example.repository;

import org.example.model.Question;
import org.example.model.Quiz;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
