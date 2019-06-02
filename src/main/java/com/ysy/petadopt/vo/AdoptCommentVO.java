package com.ysy.petadopt.vo;

import com.ysy.petadopt.entity.Member;
import lombok.Data;

import java.util.Date;

@Data
public class AdoptCommentVO {

    private Integer commentId;

    private Integer adoptId;

    private Integer memberId;

    private String content;

    private Date createTime;

    private Member member;

}
