package com.zrq.exercise.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrq.exercise.entity.Person;
import com.zrq.exercise.entity.Users;
import com.zrq.exercise.mapper.UsersMapper;
import com.zrq.exercise.server.PersonServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("person")
public class PersonController {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PersonServer personServerImpl;

    @RequestMapping({"/index","/"})
    public String index () {
        log.info("主页");
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Users> eq = wrapper.lambda().eq(Users::getId, 2);
//        usersMapper.getOne(eq)
        Users users = null;
        log.info(users.toString());
        return users.toString();
    }

    @RequestMapping("/login")
    public String toLogin(Person person) {
        String login = personServerImpl.login(person);
        return login;

    }
    @RequestMapping("/findAll")
    public List<Person> findAll() {
        List<Person> list = personServerImpl.findAll();
        log.info(list.toString());
        return list;
    }

    @RequestMapping("/instPerson")
    public String insPerson(Person person) {
        Date date = new Date();
        long time = date.getTime();
        person.setCreate_time(time);
        int i = personServerImpl.insPerson(person);
        log.info(""+i);
        return i>0?"添加成功！":"添加失败或者名称存在！";
    }


}
