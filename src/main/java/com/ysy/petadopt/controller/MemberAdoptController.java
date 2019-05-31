package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Adopt;
import com.ysy.petadopt.entity.Member;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // 查询已审核通过的
        adopt.setIsExamine(1);

        Example<Adopt> example = Example.of(adopt);
        // 构建分页对象
        Pageable pageable = PageRequest.of(--pageNum, 10);

        Page<Adopt> page = adoptService.findAll(example, pageable);

        // 弥补一对一映射不生效问题
        List<MemberInfo> memberInfoList = memberInfoService.findAll();
        Map<Integer, MemberInfo> map = new HashMap<>();
        for (MemberInfo memberInfo : memberInfoList) {
            map.put(memberInfo.getMemberId(), memberInfo);
        }

        for (Adopt adopt1 : page.getContent()) {
            adopt1.getMember().setMemberInfo(map.get(adopt1.getMember().getMemberId()));
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

        // 设置查看数+1
        adopt.setWatchCount(adopt.getWatchCount() + 1);

        // 保存到数据库
        adopt = adoptService.save(adopt);

        // 设置memberInfo
        MemberInfo memberInfo = memberInfoService.findOne(adopt.getMemberId());
        adopt.getMember().setMemberInfo(memberInfo);
        return ResultVOUtils.success(adopt);
    }

    @PostMapping("addAdopt")
    public ResultVO addAdopt(Integer animalCategoryId, Integer regionId, String title, String content, HttpSession httpSession) {
        // 构建adopt对象
        Adopt adopt = new Adopt();

        Member member = (Member) httpSession.getAttribute("member");
        if (member == null) {
            return ResultVOUtils.error(1, "请登录后发布领养");
        }

        // 设置用户id
        adopt.setMemberId(member.getMemberId());

        // 设置地区id
        adopt.setRegionId(regionId);

        // 设置宠物类别id
        adopt.setAnimalCategoryId(animalCategoryId);

        // 设置标题
        adopt.setTitle(title);

        // 设置查看数和评论数
        adopt.setWatchCount(0);
        adopt.setCommentCount(0);

        // 设置领养内容
        adopt.setContent(content);

        // 设置是否审核
        adopt.setIsExamine(0);

        // 设置时间
        adopt.setCreateTime(new Date());
        adopt.setUpdateTime(new Date());


        // 保存数据
        adopt = adoptService.save(adopt);

        return ResultVOUtils.success(adopt);
    }

}
