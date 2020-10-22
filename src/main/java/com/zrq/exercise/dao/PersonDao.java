package com.zrq.exercise.dao;

import com.zrq.exercise.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/9
 * @Version: 类说明： person数据操作层dao
 */
@Mapper
@Repository
public interface PersonDao {
    public List<Person> findall();
    public int insPerson(Person person);
    public Person findByName(@Param("name") String name);
}
