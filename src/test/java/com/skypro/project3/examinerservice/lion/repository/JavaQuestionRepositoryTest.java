package com.skypro.project3.examinerservice.lion.repository;

import com.skypro.project3.examinerservice.lion.exception.BadRequestException;
import com.skypro.project3.examinerservice.lion.exception.NotFoundQuestionException;
import com.skypro.project3.examinerservice.lion.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    private JavaQuestionRepository out;

    @BeforeEach
    void setUp() {
        out = new JavaQuestionRepository();
        out.add(new Question("JavaQuestion1", "JavaAnswer1"));
        out.add(new Question("JavaQuestion2", "JavaAnswer2"));
        out.add(new Question("JavaQuestion3", "JavaAnswer3"));
    }

    @Test
    void addNewQuestion() {
        Question expected = new Question("JavaQuestion4", "JavaAnswer4");
        Question actual = out.add(expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(out.getAll().contains(expected));
        Assertions.assertEquals(out.getAll().size(), 4);
    }

    @Test
    void addExistingQuestion() {
        Question expected = new Question("JavaQuestion3", "JavaAnswer3");
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
//        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> {
//            out.add(null);
//        });
    }

    @Test
    void removeExistingQuestion() {
        Question expected = new Question("JavaQuestion1", "JavaAnswer1");
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
//        Assertions.assertThatExceptionOfType(NotFoundQuestionException.class).isThrownBy(() -> {
//            out.remove(null);
//        });
    }

    @Test
    void getAll() {
        Assertions.assertEquals(out.getAll().size(), 3);
    }
}