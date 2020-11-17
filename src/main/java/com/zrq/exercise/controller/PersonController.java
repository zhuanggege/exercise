package com.zrq.exercise.controller;

import com.zrq.exercise.entity.Person;
import com.zrq.exercise.server.PersonServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("person")
@Api(value = "用户管理",tags = "用户管理")
public class PersonController {

//    @Autowired
//    private UsersMapper usersMapper;

    @Autowired
    private PersonServer personServerImpl;

    @PostMapping({"/index","/"})
    public String index (@Valid Integer id) {
        log.info("主页");
//        QueryWrapper<Users> wrapper = new QueryWrapper<>();
//        LambdaQueryWrapper<Users> eq = wrapper.lambda().eq(Users::getId, 2);
//        eq.last("Limit 1");
//        Users users = usersMapper.selectOne(eq);
//        log.info(users.toString());
        return "users.toString()";
    }

    @PostMapping("/login")
    public String toLogin(Person person) {
        String login = personServerImpl.login(person);
        return login;

    }
    @PostMapping("/findAll")
    @ApiOperation(value = "查询所有",notes = "查询所有")
    public List<Person> findAll() {
        List<Person> list = personServerImpl.findAll();
        log.info(list.toString());
        return list;
    }

    @PostMapping("/instPerson")
    public String insPerson(Person person) {
        Date date = new Date();
        long time = date.getTime();
        person.setCreate_time(time);
        int i = personServerImpl.insPerson(person);
        log.info(""+i);
        return i>0?"添加成功！":"添加失败或者名称存在！";
    }


}
