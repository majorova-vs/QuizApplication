package org.example.service;

import org.example.model.Answer;
import org.example.model.Question;

import java.util.List;

public interface AnswerService {
    List<Answer> allAnswers();
    Answer read(int id);
    List<Answer> answerByQuestion(int id);
    public void save(Answer answer);
}
