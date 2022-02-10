package com.dongseo.emotion.controller;

import com.dongseo.emotion.entity.Emotion;
import com.dongseo.emotion.entity.User;
import com.dongseo.emotion.service.EmotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MainController {

    private EmotionService emotionService;
    @PostMapping("login")
    public String login(@RequestParam User user, HttpSession session){
        if(user.getId().equals("admin") && user.getPw().equals("a")){
            session.setAttribute("user", "admin");
            return "redirect:/emotion/user";
        }else{
            return "login";
        }
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    @GetMapping("emotion/user")
    public List<Emotion> userEmotion(HttpSession session, Model model){
        return emotionService.userEmotionService((String)session.getAttribute("user"));
    }

    @GetMapping("emotion/user/{method}")
    public List<Emotion> userEmotionDetail(@PathVariable String method, HttpSession session, Model model){
        return emotionService.userEmotionService((String)session.getAttribute("user"));
    }
}
