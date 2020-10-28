package com.zrq.exercise.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:
 * @CreateDate: 2020/10/7
 * @Version: 类说明：
 */
@RestController
@Slf4j
@RequestMapping("/new")
public class NewPersonController {

    @RequestMapping("/index")
    public String index() {

        log.info("测试github分支和主支");
        return "测试github分支和主支";
    }







}
