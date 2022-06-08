package com.kuimov.pp.task314rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DogsController {
    @RequestMapping("/dogsList")
    public String showIndex() {
        return "dogsList";
    }
}

