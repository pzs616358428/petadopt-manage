package com.ysy.petadopt.utils;

import com.ysy.petadopt.vo.UeditorVO;

public class UeditorVOUtils {

    public static UeditorVO success(String url, String title, String original) {
        UeditorVO ueditorVO = new UeditorVO();
        ueditorVO.setState("SUCCESS");
        ueditorVO.setUrl(url);
        ueditorVO.setTitle(title);
        ueditorVO.setOriginal(original);
        return ueditorVO;
    }

}
