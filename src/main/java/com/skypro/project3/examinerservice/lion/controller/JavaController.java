package com.skypro.project3.examinerservice.lion.controller;

import com.skypro.project3.examinerservice.lion.Question;
import com.skypro.project3.examinerservice.lion.service.QuestionException;
import com.skypro.project3.examinerservice.lion.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
public class JavaController {

    private final QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }

    @PostMapping("/exam/java/add")
    public ResponseEntity<Question> addQuestion(String question, String answer) throws QuestionException {
        this.service.add(question, answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/exam/java/add")
    public ResponseEntity<Question> addQuestion(Question question) throws QuestionException {
        this.service.add(question);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/exam/java/remove")
//    public ResponseEntity<Question> removeQuestion(String question, String answer) {
//        this.service.remove(question, answer);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("/exam/java/remove")
    public ResponseEntity<Question> removeQuestion(Question question) {
        this.service.remove(question);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/exam/java")
    public ResponseEntity<Collection<Question>> getQuestions() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
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
}
