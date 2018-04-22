package com.zben.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:zben
 * @Date: 2018/4/21/021 14:10
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/404")
    public String notFoundError() {
        return "404";
    }

    @GetMapping("/500")
    public String serverError() {
        return "500";
    }

    @GetMapping("/logout/page")
    public String logout() {
        return "logout";
    }
}
