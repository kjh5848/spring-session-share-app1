package com.metacoding.spring_session_share_app1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

    @GetMapping("/app1/")
    public String home(HttpSession session, Model model) {
        // 세션에서 방문 횟수 조회
        Integer count = (Integer) session.getAttribute("count");
        if (count == null)
            count = 0;
        count++;
        session.setAttribute("count", count);

        // 서버 식별용 (app1 표시)
        model.addAttribute("server", "App1 Server");
        model.addAttribute("count", count);

        return "index";
    }
}