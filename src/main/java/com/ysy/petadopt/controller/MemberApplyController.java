package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Adopt;
import com.ysy.petadopt.entity.Apply;
import com.ysy.petadopt.entity.Member;
import com.ysy.petadopt.service.AdoptService;
import com.ysy.petadopt.service.ApplyService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ApplyVO;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/member/adopt/")
public class MemberApplyController {

    @Autowired
    private ApplyService applyService;

    @Autowired
    private AdoptService adoptService;

    @PostMapping("addApply")
    public ResultVO addApply(String applyPerson, String applyPhone, String applyReason, Integer adoptId) {
        Apply apply = new Apply();
        apply.setApplyPerson(applyPerson);
        apply.setApplyPhone(applyPhone);
        apply.setApplyReason(applyReason);
        apply.setAdoptId(adoptId);
        // 设置审核状态为未审核
        apply.setApplyStatus(0);

        apply.setCreateTime(new Date());

        apply = applyService.save(apply);

        return ResultVOUtils.success(apply);
    }

    @GetMapping("applyList")
    public ResultVO applyList(HttpSession httpSession) {
        // 构建查询参数
        Adopt adopt = new Adopt();

        Member member = (Member) httpSession.getAttribute("member");
        if (member == null) {
            return ResultVOUtils.error(1, "用户未登录");
        }
        adopt.setMemberId(member.getMemberId());

        Example<Adopt> example = Example.of(adopt);
        // 构建分页对象
        Pageable pageable = PageRequest.of(0, 100);

        Page<Adopt> page = adoptService.findAll(example, pageable);

        List<Adopt> adoptList = page.getContent();

        Map<Integer, Adopt> map = new HashMap<>();

        for (Adopt adopt1 : adoptList) {
            map.put(adopt1.getAdoptId(), adopt1);
        }

        List<Apply> applyList = applyService.findAll();

        // 筛选后的list集合
        List<Apply> applys = new ArrayList<>();

        for (Apply apply : applyList) {
            if (map.get(apply.getAdoptId()) != null) {
                applys.add(apply);
            }
        }

        List<ApplyVO> applyVOList = new ArrayList<>();

        for (Apply apply : applys) {
            ApplyVO applyVO = new ApplyVO();
            BeanUtils.copyProperties(apply, applyVO);
            applyVO.setAdopt(map.get(apply.getAdoptId()));
            applyVOList.add(applyVO);
        }

        return ResultVOUtils.success(applyVOList);
    }

    @GetMapping("changeApplyStatus")
    public ResultVO changeApplyStatus(Integer applyId, Integer status) {
        Apply apply = applyService.findById(applyId);
        apply.setApplyStatus(status);
        applyService.save(apply);
        return ResultVOUtils.success();
    }

}
