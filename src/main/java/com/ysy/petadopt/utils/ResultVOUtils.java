package com.ysy.petadopt.utils;

import com.ysy.petadopt.vo.ResultVO;

public class ResultVOUtils {

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(0);
        resultVO.setMessage("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(Integer status, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(status);
        resultVO.setMessage(message);
        return resultVO;
    }

}
