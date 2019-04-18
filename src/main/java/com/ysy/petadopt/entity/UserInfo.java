package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "p_userinfo")
public class UserInfo {

    /* 用户信息id */
    @Id
    private Integer userinfoId;
    /* 用户id */
    private Integer userId;
    /* 昵称 */
    private String nickname;
    /* 电话 */
    private String phone;
    /* 邮箱 */
    private String email;
    /* 头像 */
    private String headportrait;

}
