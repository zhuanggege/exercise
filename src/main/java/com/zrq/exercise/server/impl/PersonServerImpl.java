package com.zrq.exercise.server.impl;

import com.zrq.exercise.dao.PersonDao;
import com.zrq.exercise.entity.Person;
import com.zrq.exercise.server.PersonServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/9
 * @Version: 类说明： person业务接口实现类
 */
@Service
@Slf4j
public class PersonServerImpl implements PersonServer {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> findAll() {
        log.info("查询所有数据");
        return personDao.findall();
    }

    @Override
    public int insPerson(Person person) {

        Person byName = this.findByName(person.getName());
        if(byName != null) {
            return 0;
        }
        return personDao.insPerson(person);
    }

    @Override
    public Person findByName(String name) {
        return personDao.findByName(name);
    }

    @Override
    public String login(Person person) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(person.getName(), String.valueOf(person.getAge()));

        try {
            subject.login(token);
            return "登录成功";
        }catch (UnknownAccountException e) {
            log.info("用户名不存在！");
            return "用户名不存在";
        }catch (IncorrectCredentialsException e) {
            log.info("密码错误！");
            return "密码错误";
        }
    }
}
