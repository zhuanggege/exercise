package com.zrq.exercise.controller;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author:
 * @CreateDate: 2020/10/16
 * @Version: 类说明：
 */
@Slf4j
public class TestJava8 {
    public static void main(String[] args) {
        //给接口实现方法lambda表达式
        Mimest s = (int a,int b) -> {return  a+b; };
        Integer integer = s.pram(2, 3);
        log.info(""+integer);
    }

    interface Mimest {
        //Integer是返回类型
        Integer pram(int a,int b);
    }
}
