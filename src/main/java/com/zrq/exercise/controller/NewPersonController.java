package com.zrq.exercise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(value = "新闻",tags = "新闻")
public class NewPersonController {

    @PostMapping("/index")
    @ApiOperation(value = "主页",notes = "主页")
    public String index() {

        log.info("测试github分支和主支");
        return "测试github分支和主支";
    }







}
