package com.sg.ai;

import com.sg.ai.answer.Answer;
import com.sg.ai.question.Question;
import com.sg.ai.answer.AnswerRepository;
import com.sg.ai.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SbbApplicationTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa()
    {
        Question q1 = new Question();
        q1.setContent("오늘이 몇일 인가요");
        q1.setSubject("처음 질문");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);

    }

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpaa() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("오늘은 5월 12일 입니다");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        answerRepository.save(a);

    }
}