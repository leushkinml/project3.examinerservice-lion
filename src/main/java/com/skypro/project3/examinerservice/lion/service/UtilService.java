package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.model.Question;
import com.skypro.project3.examinerservice.lion.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Random;
@Service
public class UtilService {

    private final List<QuestionRepository> questionRepositories;;

    public UtilService(List<QuestionRepository> questionRepositories) {
        this.questionRepositories = questionRepositories;
    }

    public static int getRandomInt(int tmp) {
        int randomInt;
        return randomInt = new Random().nextInt(tmp);
    }

    public Question getRandomQuestion(Collection<Question> all) {
        int number = getRandomInt(all.size());
        var randomQuestion = questionRepositories.get(number);
        return (Question) randomQuestion;
    }
}

//    private final List<QuestionService> questionServices;;
//
//    public UtilService(List<QuestionService> questionServices) {
//        this.questionServices = questionServices;
//