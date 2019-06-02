package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "p_apply_adopt")
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applyId;

    private Integer adoptId;

    private String applyPerson;

    private String applyPhone;

    private String applyReason;

    private Integer applyStatus;

    private Date createTime;

}
