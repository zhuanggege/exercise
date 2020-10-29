package com.zrq.mybatis_test.dto.request;

import com.zrq.core.corerequest.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @Author: z
 * @CreateDate: 2020/10/29
 * @Version: 类说明：
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class UserRequest extends PageRequest<Object> {

    private Integer id;

    private String name;

    private String password;

    @Tolerate
    public UserRequest() {
        super();
    }
}
