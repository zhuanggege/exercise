package com.zrq.exercise.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonController {

    @RequestMapping("/index")
    @ResponseBody
    public String index () {
        log.info("主页");
        return "hello world !! wellcome to springboot! ";
    }



}
