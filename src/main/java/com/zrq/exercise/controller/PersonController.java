package com.zrq.exercise.controller;

import com.zrq.exercise.entity.Person;
import com.zrq.exercise.server.PersonServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonServer personServerImpl;

    @RequestMapping("/index")
    @ResponseBody
    public String index () {
        log.info("主页");

        return "hello world !! wellcome to springboot! ";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Person> findAll() {
        List<Person> list = personServerImpl.findAll();
        log.info(list.toString());
        return list;
    }

    @ResponseBody
    @RequestMapping("/instPerson")
    public String insPerson(Person person) {
        int i = personServerImpl.insPerson(person);
        log.info(""+i);
        return i>0?"添加成功！":"添加失败或者名称存在！";
    }


}
