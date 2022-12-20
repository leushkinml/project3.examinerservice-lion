package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.model.Question;

import java.util.Collection;

//  Сделать интерфейс QuestionService,
//  который будет содержать в себе все методы по работе с вопросами определенного предмета.


public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    // void remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
