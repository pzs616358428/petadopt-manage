package com.ysy.petadopt.vo;

import com.ysy.petadopt.entity.Adopt;
import lombok.Data;

import java.util.Date;

@Data
public class ApplyVO {

    private Integer applyId;

    private Integer adoptId;

    private String applyPerson;

    private String applyPhone;

    private String applyReason;

    private Integer applyStatus;

    private Date createTime;

    private Adopt adopt;

}
