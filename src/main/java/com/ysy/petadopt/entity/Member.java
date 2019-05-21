package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "p_member")
public class Member {

    /* 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    /* 会员名 */
    private String memberName;

    /* 密码 */
    private String password;

    /* 创建时间 */
    private Date createTime;

    /* 修改时间 */
    private Date updateTime;

    /* 最后登录时间 */
    private Date lastLoginTime;

    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberInfo memberInfo;

}
