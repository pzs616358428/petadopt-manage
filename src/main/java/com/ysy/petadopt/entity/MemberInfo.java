package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "p_member_info")
public class MemberInfo {

    /* 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoId;

    /* 会员id */
    private Integer memberId;

    /* 昵称 */
    private String nickname;

    /* 电话 */
    private String phone;

    /* 邮箱 */
    private String email;

    /* 头像 */
    private String headImage;

}
