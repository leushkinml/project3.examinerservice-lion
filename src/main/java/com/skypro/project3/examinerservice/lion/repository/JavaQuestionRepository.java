package com.skypro.project3.examinerservice.lion.repository;

import com.skypro.project3.examinerservice.lion.exception.BadRequestException;
import com.skypro.project3.examinerservice.lion.exception.NotFoundQuestionException;
import com.skypro.project3.examinerservice.lion.model.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

     private final Set<Question> questions = new HashSet<>();

    @PostConstruct // Эта аннотация для того, чтобы на этапе инициализации бина выполняет этот блок
    private void init() {
        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));
        questions.add(new Question("Question 3", "Answer 3"));
        questions.add(new Question("Question 4", "Answer 4"));
        questions.add(new Question("Question 5", "Answer 5"));
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new BadRequestException("Заполните поля 'Вопрос' и 'Ответ'.");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotFoundQuestionException ("Вопрос не найден.");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
