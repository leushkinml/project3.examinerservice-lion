package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

//  Сделать интерфейс QuestionService,
//  который будет содержать в себе все методы по работе с вопросами определенного предмета.

@Service
public interface QuestionService {
    Question add(String question, String answer) throws QuestionException;

    Question add(Question question) throws QuestionException;

    Question remove(Question question);

    // void remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
