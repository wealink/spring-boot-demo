package com.wework.platformservice.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
    @ApiModelProperty(value = "用户ID",example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
