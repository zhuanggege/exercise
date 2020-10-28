package com.zrq.mybatis_test.mapper;

import com.zrq.mybatis_test.entity.UsersModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表	 Mapper 接口
 * </p>
 *
 * @author zrq
 * @since 2020-10-28
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<UsersModel> {

}
