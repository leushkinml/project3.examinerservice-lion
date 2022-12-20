package com.skypro.project3.examinerservice.lion.repository;

import com.skypro.project3.examinerservice.lion.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
