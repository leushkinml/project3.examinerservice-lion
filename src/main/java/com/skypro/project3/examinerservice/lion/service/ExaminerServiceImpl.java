package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.exception.BadRequestException;
import com.skypro.project3.examinerservice.lion.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

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

   private final List<QuestionService> questionServices;
   // List используется, чтоы получать вопросы из обоих сервисов в методе getQuestions ниже
    // Метод сам выберет, из какого сервиса получать вопросы. Здесь @Qualifier не нужен

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

//     Random random;
//     private final UtilService utilService;
//    public ExaminerServiceImpl(List<QuestionService> questionServices, UtilService utilService) {
//        this.questionServices = questionServices;
//        this.utilService = utilService;
//    }

    private int calculateAmountOfQuestions() {
        return questionServices.stream()
                .mapToInt(s -> s.getAll().size())
                .sum();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || calculateAmountOfQuestions() < amount) {
            throw new BadRequestException("Некорректное количество " + amount);
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            var serviceNumber = UtilService.getRandomInt(questionServices.size()); // Метод сам выберет, из какого
            // сервиса получать вопросы. Мы этого не знаем. Решиться рандомно
            var questionService = questionServices.get(serviceNumber);
            result.add(questionService.getRandomQuestion());
        }
        return result;
      }
}


//@Override
//    public Collection<Question> getQuestions(int amount) {
//        if (amount <= 0 || calculateAmountOfQuestions() < amount) {
//            throw new BadRequestException("Некорректное количество " + amount);
//        }
//        Set<Question> result = new HashSet<>();
//        while (result.size() < amount) {
////            var serviceNumber = UtilService.getRandomInt(questionServices.size()); // Метод сам выберет, из какого
////            // сервиса получать вопросы. Мы этого не знаем. Решиться рандомно
////            var questionService = questionServices.get(serviceNumber);
//            result.add(utilService.getRandomQuestion());
//        }
//        return result;
//    }
//    private final List<QuestionService> questionServices;
//    // List используется, чтоы получать вопросы из обоих сервисов в методе getQuestions ниже
//    // Метод сам выберет, из какого сервиса получать вопросы. Здесь @Qualifier не нужен
//    private final UtilService utilService;
//    // Random random;
//    public ExaminerServiceImpl(List<QuestionService> questionServices, UtilService utilService) {
//        this.questionServices = questionServices;
//        this.utilService = utilService;
//    }
//    @Override
//    public Collection<Question> getQuestions(int amount) {
//        if (amount <= 0 || calculateAmountOfQuestions() < amount) {
//            throw new BadRequestException("Некорректное количество " + amount);
//        }
//        Set<Question> result = new HashSet<>();
//        while (result.size() < amount) {
//            var serviceNumber = UtilService.getRandomInt(questionServices.size()); // Метод сам выберет, из какого
//            // сервиса получать вопросы. Мы этого не знаем. Решиться рандомно
//            var questionService = questionServices.get(serviceNumber);
//            result.add(questionService.getRandomQuestion());
//        }
//        return result;
//    }
//    private int calculateAmountOfQuestions() {
//        return questionServices.stream()
//                .mapToInt(s -> s.getAll().size())
//                .sum();
//    }