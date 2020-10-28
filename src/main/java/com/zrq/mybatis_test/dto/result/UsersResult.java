package com.zrq.mybatis_test.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UsersResult {

    private Integer id;

    @JsonIgnore
    private String name;

    private String password;

    @Tolerate
    public UsersResult() {
    }
}
