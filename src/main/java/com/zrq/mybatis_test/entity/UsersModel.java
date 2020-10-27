package com.zrq.mybatis_test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * <p>
 * 用户表	
 * </p>
 *
 * @author zrq
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("users")
@Repository
@AllArgsConstructor
@Validated
public class UsersModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;


}
