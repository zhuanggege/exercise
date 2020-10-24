package com.zrq.exercise.mapper;

import com.zrq.exercise.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表	 Mapper 接口
 * </p>
 *
 * @author zrq
 * @since 2020-10-18
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {

}
