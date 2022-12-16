package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//   Реализовать сервис JavaQuestionService, который будет реализовывать QuestionService
//   и хранить в себе список вопросов по Java, а также осуществлять всю работу с этим списком.
//   Реализация метода getRandomQuestion осуществляется с помощью класса Random и его метода nextInt,
//   который в качестве параметра принимает максимальное число,
//   а затем возвращает вам результат в виде случайного числа от 0 до максимального числа из параметров (не включительно).

//@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) throws QuestionException {

        if (question == null || answer == null) {
            throw new QuestionException("Заполните поля 'Вопрос' и 'Ответ'.");
        }
        Question questionTmpr = new Question(question, answer);
        this.questions.add(questionTmpr);
        return questionTmpr;
    }

    @Override
    public Question add(Question question) throws QuestionException {

        if (question.getQuestion() == null || question.getAnswer() == null) {
            throw new QuestionException("Заполните поля 'Вопрос' и 'Ответ'.");
        }
        Question questionTmpr = new Question(question.getQuestion(), question.getAnswer());
        this.questions.add(questionTmpr);
        return questionTmpr;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return this.questions;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
