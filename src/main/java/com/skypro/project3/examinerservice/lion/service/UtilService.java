package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class UtilService {
    private static Random random;

    // @Autowired
    public void setRandom(Random random) {
        UtilService.random = random;
    }

    public int getRandomInt(int bound) {

        return random.nextInt(bound);
    }

    public Question getRandomQuestion(Collection<Question> questions) {
        int questionNum = getRandomInt(questions.size());
        int questionCur = 0;
        for (Question question : questions) {
            if (questionCur == questionNum) {
                return question;
            }
            questionCur++;
        }
        return null;
    }
}
