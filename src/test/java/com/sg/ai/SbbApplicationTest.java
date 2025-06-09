package com.sg.ai;

import com.sg.ai.answer.Answer;
import com.sg.ai.question.Question;
import com.sg.ai.answer.AnswerRepository;
import com.sg.ai.question.QuestionRepository;
import com.sg.ai.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SbbApplicationTest {

//    @Autowired
//    private QuestionRepository questionRepository;
//
//    @Test
//    void testJpa()
//    {
//        Question q1 = new Question();
//        q1.setContent("오늘이 몇일 인가요");
//        q1.setSubject("처음 질문");
//        q1.setCreateDate(LocalDateTime.now());
//        questionRepository.save(q1);
//
//    }
//
//    @Autowired
//    private AnswerRepository answerRepository;
//
//    @Test
//    void testJpaa() {
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("오늘은 5월 12일 입니다");
//        a.setQuestion(q);
//        a.setCreateDate(LocalDateTime.now());
//        answerRepository.save(a);
//
//    }

    // 페이지 기능을 구현하기 위해, 300개의 게시물을 만듬
    @Autowired
    private QuestionService questionService;

    @Test
    void testPage()
    {
        for(int i=1;i<=300;i++)
        {
            String subject = String.format("테스트용으로 만들었습니다 : [%03d]", i);
            String content = "별 내용 없습니다. 2025년 6월 9일 마지막 수업";

            this.questionService.create(subject, content);

        }
    }
}
