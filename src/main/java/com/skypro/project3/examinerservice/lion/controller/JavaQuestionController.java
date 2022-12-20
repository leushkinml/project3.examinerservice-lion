package com.skypro.project3.examinerservice.lion.controller;

import com.skypro.project3.examinerservice.lion.model.Question;
import com.skypro.project3.examinerservice.lion.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.questionService = javaQuestionService;
    }

    @GetMapping()
    public ResponseEntity<Collection<Question>> getQuestions() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.add(question, answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Question> removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.remove(new Question(question, answer));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
//    Пользователь обращается к некому эндпоинту по адресу (”/exam/get/{amount}”)
//    Пользователь получает ответ в виде списка случайных вопросов-ответов,
//    количество которых равно amount из прошлого шага
//    Пользователь должен иметь возможность добавить,
//    получить и удалить вопросы из хранилища вопросов (”/exam/java/(add/remove/find)”)

//    Контроллер должен иметь три метода: добавить, удалить и получить все вопросы.
//    Эти методы должны висеть на следующих эндпоинтах:
//    Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
//    Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
//    Получить все вопросы: “/exam/java”

//    @GetMapping
//    public Collection<Question> getQuestions() {
//
//        return questionService.getAll();
//    }
//    @GetMapping("/add")
//    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
//        return questionService.add(question, answer);
//    }
//    @GetMapping("/remove")
//    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
//        return questionService.remove(new Question(question, answer));
//    }

