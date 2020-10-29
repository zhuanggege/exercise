package com.zrq.mybatis_test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrq.core.corerequest.PageRequest;
import com.zrq.mybatis_test.dto.request.UserRequest;
import com.zrq.mybatis_test.dto.result.UsersResult;
import com.zrq.mybatis_test.entity.UsersModel;
import com.zrq.mybatis_test.mapper.UsersMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UsersService extends ServiceImpl<UsersMapper, UsersModel>{

    private final UsersMapper usersMapper;

    private final ModelMapper modelMapper;


    @Transactional(readOnly = true)
    public IPage<UsersResult> selUsers(PageRequest<UserRequest> page) {

        Page<UsersModel> modelPage = usersMapper.selectPage(new Page<>(page.getPageNo(), page.getPageSize()), null);
        IPage<UsersResult> resultIPage = modelPage.convert(f -> modelMapper.map(f, UsersResult.class));
        return resultIPage;
    }

    @Transactional(readOnly = false)
    public Integer updateUserName(UserRequest userRequest) {

        int updateById = usersMapper.updateById(modelMapper.map(userRequest, UsersModel.class));
        return updateById;
    }




}
