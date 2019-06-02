package com.ysy.petadopt.vo;

import com.ysy.petadopt.entity.Member;
import lombok.Data;

import java.util.Date;

@Data
public class ReturnVisitVO {

    private Integer visitId;

    private Integer memberId;

    private String content;

    private Integer watchCount;

    private Integer commentCount;

    private String images;

    private Date createTime;

    private Member member;

}
