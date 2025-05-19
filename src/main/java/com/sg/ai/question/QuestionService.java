package com.sg.ai.question;

import com.sg.ai.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList()
    {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent())
        {
            return question.get();
        } else {
            throw new DataNotFoundException("Data not found: 그런 질문 없음");
        }
    }

    @Transactional
    public void create(String subject, String content)
    {
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        questionRepository.save(question);
    }

}
