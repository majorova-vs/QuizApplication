package org.example.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.example.model.Question;
import org.example.model.Quiz;
import org.example.service.QuestionService;
import org.example.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {
    private QuizService quizService;
    private QuestionService questionService;

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }
    @Autowired
    public void setQuestionService(QuestionService questionService) {this.questionService = questionService; }

    @GetMapping("/addQuiz")
    public String addQuizPage(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "addQuiz";
    }

    @PostMapping("/addQuiz")
    public String addQuiz(@ModelAttribute("quiz") Quiz quiz, Model model) {
        quizService.save(quiz);
        return "redirect:/addQuestion";
    }

    @GetMapping("/addQuestion/{id}")
    public String addQuestionPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("quiz", quizService.getById(id));
        return "addQuestion";
    }

    @PostMapping("/addQuestion/{id}")
    public String addQuestion(@PathVariable("id") int id, @ModelAttribute("question") Question question,
                              @ModelAttribute("quiz") Quiz quiz, Model model) {
        question.setQuiz(quiz);
        questionService.save(question);
        return "redirect:/addQuestion/{id}";
    }

    @GetMapping("/allQuizzes")
    public String allQuizzesPage(Model model) {
        model.addAttribute("quizzes", quizService.listAll());
        return "allQuizzes";
    }

    @GetMapping("/quizzes/{id}")
    public String runQuiz(@PathVariable("id") int id, Model model) {

        List<Question> questions = questionService.questionByQuiz(id);
        model.addAttribute("questions", questions);
        return "/questions";
    }
}
