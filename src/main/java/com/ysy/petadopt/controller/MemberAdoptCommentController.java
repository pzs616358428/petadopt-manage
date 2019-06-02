package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.AdoptComment;
import com.ysy.petadopt.entity.Member;
import com.ysy.petadopt.entity.MemberInfo;
import com.ysy.petadopt.service.AdoptCommentService;
import com.ysy.petadopt.service.MemberInfoService;
import com.ysy.petadopt.service.MemberService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.AdoptCommentVO;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/member/adopt/")
public class MemberAdoptCommentController {

    @Autowired
    private AdoptCommentService adoptCommentService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberInfoService memberInfoService;

    @PostMapping("addComment")
    public ResultVO addComment(HttpSession httpSession, Integer adoptId, String content) {
        Member member = (Member) httpSession.getAttribute("member");
        if (member == null) {
            return ResultVOUtils.error(1, "未登录");
        }

        AdoptComment adoptComment = new AdoptComment();

        adoptComment.setAdoptId(adoptId);
        adoptComment.setMemberId(member.getMemberId());
        adoptComment.setContent(content);
        adoptComment.setCreateTime(new Date());

        adoptComment = adoptCommentService.save(adoptComment);

        return ResultVOUtils.success(adoptComment);
    }

    @GetMapping("commentList")
    public ResultVO commentList(Integer adoptId) {
        List<AdoptComment> adoptCommentList = adoptCommentService.findByAdoptId(adoptId);

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

        // 构建volist
        List<AdoptCommentVO> adoptCommentVOList = new ArrayList<>();

        for (AdoptComment adoptComment : adoptCommentList) {
            AdoptCommentVO adoptCommentVO = new AdoptCommentVO();
            BeanUtils.copyProperties(adoptComment, adoptCommentVO);

            adoptCommentVO.setMember(memberMap.get(adoptCommentVO.getMemberId()));

            adoptCommentVO.getMember().setMemberInfo(memberInfoMap.get(adoptCommentVO.getMemberId()));

            adoptCommentVOList.add(adoptCommentVO);
        }

        return ResultVOUtils.success(adoptCommentVOList);
    }

}
