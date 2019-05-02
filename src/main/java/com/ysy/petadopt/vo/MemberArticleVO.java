package com.ysy.petadopt.vo;

import com.ysy.petadopt.entity.Article;
import lombok.Data;

import java.util.List;

@Data
public class MemberArticleVO {

    private List<Article> list;
    private PageVO page;

}
