package com.zrq.mybatis_test.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @Author:
 * @CreateDate: 2020/10/29
 * @Version: 类说明：
 */
@Data
@Builder
public class UserRequest {

    private Integer id;

    private String name;

    private String password;

    @Tolerate
    public UserRequest() {
    }
}
