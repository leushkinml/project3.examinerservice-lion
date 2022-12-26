package com.skypro.project3.examinerservice.lion.repository;

import com.skypro.project3.examinerservice.lion.exception.BadRequestException;
import com.skypro.project3.examinerservice.lion.exception.NotFoundQuestionException;
import com.skypro.project3.examinerservice.lion.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {

    private MathQuestionRepository out;

    @BeforeEach
    void setUp() {
        out = new MathQuestionRepository();
        out.add(new Question("MathQuestion1", "MathAnswer1"));
        out.add(new Question("MathQuestion2", "MathAnswer2"));
        out.add(new Question("MathQuestion3", "MathAnswer3"));
    }

    @Test
    void addNewQuestion() {
        Question expected = new Question("MathQuestion4", "MathAnswer4");
        Question actual = out.add(expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(out.getAll().contains(expected));
        Assertions.assertEquals(out.getAll().size(), 4);
    }

    @Test
    void addExistingQuestion() {
        Question expected = new Question("MathQuestion3", "MathAnswer3");
        Assertions.assertTrue(out.getAll().contains(expected));
        Question actual = out.add(expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(out.getAll().size(), 3);
    }

    @Test
    void addNullQuestion() {
        Assertions.assertThrows(BadRequestException.class, () -> {
            out.add(null);
        });
    }

    @Test
    void removeExistingQuestion() {
        Question expected = new Question("MathQuestion1", "MathAnswer1");
        Question actual = out.remove(expected);
        Assertions.assertEquals(expected, actual);
        System.out.println(out.getAll());
        Assertions.assertEquals(out.getAll().size(), 2);
    }

    @Test
    void removeNotExistingQuestion() {
        Assertions.assertThrows(NotFoundQuestionException.class, () -> {
            out.remove(null);
        });
    }

    @Test
    void getAll() {
        Assertions.assertEquals(out.getAll().size(), 3);
    }
}