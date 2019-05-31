package com.ysy.petadopt.vo;

import com.ysy.petadopt.entity.Adopt;
import lombok.Data;

import java.util.List;

@Data
public class MemberAdoptVO {

    private List<Adopt> adoptList;
    private PageVO page;

}
