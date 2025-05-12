package com.sg.ai.controller;

import com.sg.ai.user.User;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController

public class RestController {
    @GetMapping("/jblog")
    public User httpGet() {
        User finduser = User.builder()
                .id(1)
                .username("ai")
                .password("222")
                .email("ai@ai.com")
                .build();
        return finduser;
    }

    @PostMapping("/jblog")
    public String httpPost(@RequestBody User user)
    {
        return "Post request processed" + user.toString();
    }

    @PutMapping("/jblog")
    public String httpPut(@RequestBody User user)
    {
        return "Put request processed" + user.toString();
    }

    @DeleteMapping("/jblog")
    public String httpDelete(@RequestParam int id)
    {
        return "Delete request processed" + id;
    }
}
