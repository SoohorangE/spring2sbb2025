package com.sg.ai.question;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model)
    {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping("/question/detail/{id}")
    public String detail(Model model, @PathVariable Integer id)
    {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/question/create")
    public String questionCreate()
    {
        return "question_form";
    }

    @PostMapping("/question/create")
    public String questionCreatePost(@RequestParam(value="subject") String subject,
                                     @RequestParam(value="content") String content)
    {

        questionService.create(subject, content);

        return "redirect:/question/list";
    }

    // 메소드 접근제어
    // public, protected, private, default

//    public void pubmethod() {}
//    private void primethod() {}
//    protected void promethod() {}
//    void defmethod()
//    {
//
//    }
}
