package org.example.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.example.model.Quiz;
import org.example.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuizController {
    private QuizService quizService;

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/addQuiz")
    public String addQuizPage(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "addQuiz";
    }

    @PostMapping("/addQuiz")
    public String addQuiz(@ModelAttribute("quiz") Quiz quiz, Model model) {
        quizService.save(quiz);
        return "redirect:/";
    }
}
