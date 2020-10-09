package com.zrq.exercise.server.impl;

import com.zrq.exercise.dao.PersonDao;
import com.zrq.exercise.entity.Person;
import com.zrq.exercise.server.PersonServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/9
 * @Version: 类说明： person业务接口实现类
 */
@Service
@Slf4j
public class PersonServerImpl implements PersonServer {

    @Resource
    private PersonDao personDao;

    @Override
    public List<Person> findAll() {
        log.info("查询所有数据");
        return personDao.findall();
    }

    @Override
    public int insPerson(Person person) {
        return personDao.insPerson(person);
    }
}
