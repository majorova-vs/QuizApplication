package org.example.repository;

import org.example.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    //@Query("select q from Questions q where q.quizId = ?1")
    public List<Question> findByQuizId(int quizId);
}
