package com.zrq.exercise.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping("/index")
    @ResponseBody
    public String index () {

        return "hello world !! wellcome to springboot! ";
    }



}
