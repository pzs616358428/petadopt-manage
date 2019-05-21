package com.ysy.petadopt.controller;

import com.ysy.petadopt.service.RegionService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/adopt/")
public class MemberRegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("regionList")
    public ResultVO regionList() {
        return ResultVOUtils.success(regionService.findAll());
    }

}
