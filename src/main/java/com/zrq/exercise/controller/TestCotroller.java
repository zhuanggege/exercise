package com.zrq.exercise.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/7
 * @Version: 类说明： 用于测试
 */
@RestController
@Slf4j
public class TestCotroller {

    @ResponseBody
    @RequestMapping("/test")
    public Object test() {

        log.info("测试");
        Object put = new JSONObject().put("name", "小庄");
        return put;
    }



}
