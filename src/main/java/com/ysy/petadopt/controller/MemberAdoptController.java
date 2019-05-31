package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Adopt;
import com.ysy.petadopt.entity.MemberInfo;
import com.ysy.petadopt.service.AdoptService;
import com.ysy.petadopt.service.MemberInfoService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.MemberAdoptVO;
import com.ysy.petadopt.vo.PageVO;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/adopt/")
public class MemberAdoptController {

    @Autowired
    private AdoptService adoptService;

    @Autowired
    private MemberInfoService memberInfoService;

    @GetMapping("adoptList")
    public ResultVO adoptList(@RequestParam(defaultValue = "1") Integer pageNum, Integer regionId, Integer animalCategoryId) {
        // 构建查询参数
        Adopt adopt = new Adopt();
        if (regionId != null) {
            adopt.setRegionId(regionId);
        }
        if (animalCategoryId != null) {
            adopt.setAnimalCategoryId(animalCategoryId);
        }
        Example<Adopt> example = Example.of(adopt);
        // 构建分页对象
        Pageable pageable = PageRequest.of(--pageNum, 10);

        Page<Adopt> page = adoptService.findAll(example, pageable);

        // 弥补一对一映射不生效问题

        for (Adopt adopt1 : page.getContent()) {
            adopt1.getMember().setMemberInfo(memberInfoService.findOne(adopt1.getMember().getMemberId()));
        }

        // 构建vo对象
        MemberAdoptVO memberAdoptVO = new MemberAdoptVO();
        memberAdoptVO.setAdoptList(page.getContent());

        memberAdoptVO.setPage(PageVO.of(page.getNumber() + 1, page.getTotalPages(), page.getTotalElements(),
                page.isFirst(), page.isLast(), page.hasNext(), page.hasPrevious()));

        return ResultVOUtils.success(memberAdoptVO);
    }

    @GetMapping("adoptDetail")
    public ResultVO adoptDetail(Integer adoptId) {
        Adopt adopt = adoptService.findAdoptById(adoptId);
        // 设置memberInfo
        MemberInfo memberInfo = memberInfoService.findOne(adopt.getMemberId());
        adopt.getMember().setMemberInfo(memberInfo);
        return ResultVOUtils.success(adopt);
    }

}
