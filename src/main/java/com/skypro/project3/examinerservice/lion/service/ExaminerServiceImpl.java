package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

//   Реализовать ExaminerServiceImpl, который является реализацией интерфейса ExaminerService.
//   Данный сервис должен внутри себя хранить поля типа QuestionService.
//   Его задача: создать коллекцию и заполнить её с помощью вызова
//   getRandomQuestion у QuestionService случайными вопросами.
//     Учтите:
//     1.  Вопросы должны быть уникальные, следовательно, для получения 5 вопросов может потребоваться
//     более 5 вызовов метода getRandomQuestion сервиса вопросов.
//     2. Если запрошено большее количество вопросов, чем хранится в сервисе, нужно выкинуть исключение.
//     Для этого, соответственно, нужно написать свое исключение со статусом BAD_REQUEST.

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;
    QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
