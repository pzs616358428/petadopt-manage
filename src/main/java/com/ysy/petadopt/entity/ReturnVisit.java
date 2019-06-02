package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "p_return_visit")
public class ReturnVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer visitId;

    private Integer memberId;

    private String content;

    private Integer watchCount;

    private Integer commentCount;

    private String images;

    private Date createTime;

}
