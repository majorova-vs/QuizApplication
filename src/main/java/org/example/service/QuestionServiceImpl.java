package org.example.service;

import org.example.model.Question;
import org.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question read(int id) {
        return null;
    }

    @Override
    public List<Question> questionByQuiz(int id) {
        return questionRepository.findByQuizId(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }
}
