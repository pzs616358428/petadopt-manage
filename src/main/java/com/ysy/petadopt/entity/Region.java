package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "p_region")
public class Region {

    /* 地区id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionId;

    /* 地区名 */
    private String regionName;

    /* 地区描述 */
    private String description;

    /* 主题数 */
    private Integer themeCount;

    /* 帖子数 */
    private Integer postCount;

    /* 最后发表 */
    private Date lastTime;

}
