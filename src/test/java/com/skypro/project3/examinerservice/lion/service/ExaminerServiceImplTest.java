package com.skypro.project3.examinerservice.lion.service;

import com.skypro.project3.examinerservice.lion.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    QuestionService questionService;

    @Mock
    UtilService utilService;

    @BeforeEach
    void setUp() {

        out = new ExaminerServiceImpl(List.of(questionService), utilService);
    }

    @Test
    void getQuestionsWithCorrectAmount() {
        Question expected = new Question("Question", "Answer");

        Collection<Question> expectedList = Set.of(expected);
        Mockito.when(utilService.getRandomInt(anyInt())).thenReturn(0);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedList);

        Collection<Question> actualList = out.getQuestions(1);
        // Assertions.assertT(actualList).isEqualTo(expectedList);
        Assertions.assertEquals(actualList, expectedList);

        Mockito.verify(questionService, Mockito.times(1)).getAll();
        Mockito.verify(questionService, Mockito.times(1)).getRandomQuestion();
        Mockito.verify(utilService, Mockito.times(1)).getRandomInt(anyInt());
    }

//    @Test
//    void getQuestions() {
//    }
}