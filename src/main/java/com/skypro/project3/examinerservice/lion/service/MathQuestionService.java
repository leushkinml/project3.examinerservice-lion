package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.exception.BadRequestException;
import com.skypro.project3.examinerservice.lion.model.Question;
import com.skypro.project3.examinerservice.lion.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;
    // Здесь вместо поля Репозиторий может сразу быть Мапа или список, которые хранят вопросы.

    private final UtilService utilService;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository,
                               UtilService utilService) {
        this.questionRepository = questionRepository;
        this.utilService = utilService;
    }

    @Override
    public Question add(String question, String answer) {

        if (question == null || question.isBlank()) {
            throw new BadRequestException("Заполните поля 'Вопрос' и 'Ответ'.");
        }

        if (answer == null || answer.isBlank()) {
            throw new BadRequestException("Заполните поля 'Вопрос' и 'Ответ'.");
        }

        return questionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {

        if (question.getQuestion() == null
                || question.getAnswer() == null
                || question.getQuestion().isBlank()
                || question.getAnswer().isBlank()) {
            throw new BadRequestException("Заполните поля 'Вопрос' и 'Ответ'.");
        }
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {

        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {

        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        return utilService.getRandomQuestion(questionRepository.getAll());
    }
}
