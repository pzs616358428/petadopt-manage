package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "p_adopt")
public class Adopt {

    /* 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adoptId;

    /* 会员id */
    private Integer memberId;

    /* 地区id */
    private Integer regionId;

    /* 宠物类别id */
    private Integer animalCategoryId;

    /* 标题 */
    private String title;

    /* 查看个数 */
    private Integer watchCount;

    /* 评论数 */
    private Integer commentCount;

    /* 文章内容 */
    private String content;

    /* 是否审核 */
    private Integer isExamine;

    /* 创建时间 */
    private Date createTime;

    /* 修改时间 */
    private Date updateTime;

    @OneToOne
    @JoinColumn(name = "memberId", insertable = false, updatable = false)
    private Member member;

    @OneToOne
    @JoinColumn(name = "regionId", insertable = false, updatable = false)
    private Region region;

    @OneToOne
    @JoinColumn(name = "animalCategoryId", insertable = false, updatable = false)
    private AnimalCategory animalCategory;

}
