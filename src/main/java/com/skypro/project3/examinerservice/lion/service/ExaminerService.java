package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.model.Question;

import java.util.Collection;

// Этот интерфейс должен содержать один метод, который вернет список вопросов.

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}
