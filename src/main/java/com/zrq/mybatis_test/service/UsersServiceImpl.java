package com.zrq.mybatis_test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrq.mybatis_test.entity.UsersModel;
import com.zrq.mybatis_test.mapper.UsersMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 用户表	 服务实现类
 * </p>
 *
 * @author zrq
 * @since 2020-10-28
 */
@Service
@AllArgsConstructor
@Validated
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersModel> {

}
