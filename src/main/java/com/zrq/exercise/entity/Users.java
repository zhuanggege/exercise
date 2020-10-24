package com.zrq.exercise.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * <p>
 * 用户表	
 * </p>
 *
 * @author zrq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Users implements Serializable {

    public Users(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Tolerate
    public Users() {
    }

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String password;


}
