package com.zrq.exercise.server;

import com.zrq.exercise.entity.Person;

import java.util.List;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/9
 * @Version: 类说明： person实体类的业务层接口
 */
public interface PersonServer {
    /**
     * 查询所有数据
     */
    public List<Person> findAll();
    /**
     * 新增一条数据
     */
    public int insPerson(Person person);

}
