package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity(name = "p_user")
public class User {

    /* 用户id */
    @Id
    private Integer userId;
    /* 用户名 */
    private String username;
    /* 密码 */
    private String password;
    /* 创建时间 */
    private Date createTime;
    /* 修改时间 */
    private Date updateTime;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserInfo userInfo;

}
