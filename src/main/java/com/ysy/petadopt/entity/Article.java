package com.ysy.petadopt.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "p_article")
public class Article {

    /* 文章id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;

    /* 文章标题 */
    private String title;

    /* 文章主图 */
    private String mainImage;

    /* 文章描述 */
    private String description;

    /* 文章内容 */
    private String content;

    /* 围观数 */
    private Integer watchCount;

    /* 评论数 */
    private Integer commentCount;

    /* 创建时间 */
    private Date createTime;

    /* 修改时间 */
    private Date updateTime;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "animal_category_id")
    private AnimalCategory animalCategory;

    @OneToOne
    @JoinColumn(name = "article_category_id")
    private ArticleCategory articleCategory;

}
