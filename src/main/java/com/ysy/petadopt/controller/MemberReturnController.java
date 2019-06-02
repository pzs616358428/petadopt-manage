package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Member;
import com.ysy.petadopt.entity.MemberInfo;
import com.ysy.petadopt.entity.ReturnVisit;
import com.ysy.petadopt.service.MemberInfoService;
import com.ysy.petadopt.service.MemberService;
import com.ysy.petadopt.service.ReturnVisitService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import com.ysy.petadopt.vo.ReturnVisitVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/member/visit/")
public class MemberReturnController {

    @Autowired
    private ReturnVisitService returnVisitService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberInfoService memberInfoService;

    @PostMapping("addVisit")
    public ResultVO addVisit(HttpSession httpSession, String content, String images) {

        Member member = (Member) httpSession.getAttribute("member");
        if (member == null) {
            return ResultVOUtils.error(1, "未登录");
        }

        ReturnVisit returnVisit = new ReturnVisit();

        returnVisit.setMemberId(member.getMemberId());
        returnVisit.setCommentCount(0);
        returnVisit.setContent(content);
        returnVisit.setCreateTime(new Date());
        returnVisit.setImages(images);
        returnVisit.setWatchCount(0);

        returnVisit = returnVisitService.save(returnVisit);

        return ResultVOUtils.success(returnVisit);
    }

    @GetMapping("visitList")
    public ResultVO visitList() {
        List<ReturnVisit> returnVisitList = returnVisitService.findAll();

        List<Member> memberList = memberService.findAll();

        Map<Integer, Member> memberMap = new HashMap<>();

        for (Member member : memberList) {
            memberMap.put(member.getMemberId(), member);
        }

        List<MemberInfo> memberInfoList = memberInfoService.findAll();

        Map<Integer, MemberInfo> memberInfoMap = new HashMap<>();

        for (MemberInfo memberInfo : memberInfoList) {
            memberInfoMap.put(memberInfo.getMemberId(), memberInfo);
        }

        List<ReturnVisitVO> returnVisitVOList = new ArrayList<>();

        for (ReturnVisit returnVisit : returnVisitList) {
            ReturnVisitVO returnVisitVO = new ReturnVisitVO();

            BeanUtils.copyProperties(returnVisit, returnVisitVO);

            returnVisitVO.setMember(memberMap.get(returnVisitVO.getMemberId()));

            returnVisitVO.getMember().setMemberInfo(memberInfoMap.get(returnVisitVO.getMemberId()));

            returnVisitVOList.add(returnVisitVO);

        }

        return ResultVOUtils.success(returnVisitVOList);
    }

}
