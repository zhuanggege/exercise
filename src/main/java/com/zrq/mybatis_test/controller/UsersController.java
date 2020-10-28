package com.zrq.mybatis_test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zrq.core.corerequest.PageRequest;
import com.zrq.mybatis_test.dto.request.UserRequest;
import com.zrq.mybatis_test.dto.result.UsersResult;
import com.zrq.mybatis_test.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zrq
 * @CreateDate: 2020/10/28
 * @Version: 类说明： users控制层
 */
@RestController
@Slf4j
@RequestMapping("/users")
@AllArgsConstructor
@Validated
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/users_sellist")
    public String selUsers(@RequestBody PageRequest<UserRequest> pageRequest) {

        IPage<UsersResult> resultIPage = usersService.selUsers(pageRequest);
        List<UsersResult> records = resultIPage.getRecords();
        records.forEach(System.out::println);
        return records.toString();

    }

}
