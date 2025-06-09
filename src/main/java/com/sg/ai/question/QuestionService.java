package com.sg.ai.question;

import com.sg.ai.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate")); // ✅ 올바른 필드 이름 사용
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts)); // ✅ 정렬 적용
        return questionRepository.findAll(pageable);
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
