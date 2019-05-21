package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Member;
import com.ysy.petadopt.entity.MemberInfo;
import com.ysy.petadopt.service.MemberInfoService;
import com.ysy.petadopt.service.MemberService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/member/user/")
public class MemberLoginController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberInfoService memberInfoService;

    @PostMapping("login")
    public ResultVO login(String memberName, String password, HttpSession httpSession) {
        // 构建查询参数
        Member member = new Member();
        member.setMemberName(memberName);
        member.setPassword(password);
        Example<Member> example = Example.of(member);

        // 业务层查询member对象
        member = memberService.findOneByParm(example);
        if (member != null) {
            // 登录成功
            // 修改最后登录时间
            member.setLastLoginTime(new Date());
            member = memberService.save(member);
            // 将信息存储到session中
            httpSession.setAttribute("member", member);
            return ResultVOUtils.success(member);
        } else {
            // 登录失败
            return ResultVOUtils.error(1, "用户名密码不正确");
        }
    }

    @PostMapping("register")
    public ResultVO register(String memberName, String password, String phone, String email) {
        // 构建查询
        Member member = new Member();
        member.setMemberName(memberName);
        Example<Member> example = Example.of(member);

        member = memberService.findOneByParm(example);
        if (member == null) {
            // 可以注册
            member = new Member();
            member.setMemberName(memberName);
            member.setPassword(password);
            member.setCreateTime(new Date());
            member.setUpdateTime(new Date());

            // 保存会员
            member = memberService.save(member);

            // 保存会员信息
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemberId(member.getMemberId());
            memberInfo.setPhone(phone);
            memberInfo.setEmail(email);
            memberInfo.setNickname("网站用户" + System.currentTimeMillis());

            memberInfo = memberInfoService.save(memberInfo);

            // 将会员信息设置到会员中
            member.setMemberInfo(memberInfo);

            return ResultVOUtils.success(member);
        } else {
            return ResultVOUtils.error(1, "用户名已存在");
        }
    }

}
