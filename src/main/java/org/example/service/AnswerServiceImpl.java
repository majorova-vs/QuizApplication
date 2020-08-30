package org.example.service;

import org.example.model.Answer;
import org.example.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;


    @Override
    public List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer read(int id) {
        return answerRepository.findById(id).get();
    }

    @Override
    public List<Answer> answerByQuestion(int id) {
        return null;
    }

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
