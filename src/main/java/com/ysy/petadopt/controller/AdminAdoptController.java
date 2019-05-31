package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Adopt;
import com.ysy.petadopt.entity.MemberInfo;
import com.ysy.petadopt.service.AdoptService;
import com.ysy.petadopt.service.MemberInfoService;
import com.ysy.petadopt.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/adopt/")
public class AdminAdoptController {

    @Autowired
    private AdoptService adoptService;

    @Autowired
    private MemberInfoService memberInfoService;

    @GetMapping("adoptList")
    public String adoptList(ModelMap modelMap, @RequestParam(defaultValue = "1") Integer pageNum) {
        Pageable pageable = PageRequest.of(--pageNum, 10);
        Page<Adopt> page = adoptService.findAll(pageable);

        // 拟补member一对一失效
        List<MemberInfo> memberInfoList = memberInfoService.findAll();
        Map<Integer, MemberInfo> map = new HashMap<>();
        for (MemberInfo memberInfo : memberInfoList) {
            map.put(memberInfo.getMemberId(), memberInfo);
        }

        for (Adopt adopt : page.getContent()) {
            adopt.getMember().setMemberInfo(map.get(adopt.getMember().getMemberId()));
        }

        modelMap.put("navigationNums", PageUtils.getNavigationNums(page));

        modelMap.put("page", page);
        return "adopt/adopt_list";
    }


    @GetMapping("deleteAdopt")
    public String deleteAdopt(Integer adoptId) {
        adoptService.deleteById(adoptId);
        return "redirect:adoptList";
    }

    @GetMapping("adoptDetail")
    public String adoptDetail(ModelMap modelMap, Integer adoptId) {
        Adopt adopt = adoptService.findAdoptById(adoptId);
        adopt.getMember().setMemberInfo(memberInfoService.findOne(adopt.getMemberId()));
        modelMap.put("adopt", adopt);
        return "adopt/adopt_detail";
    }

    @GetMapping("examine")
    public String examine(Integer adoptId) {
        Adopt adopt = adoptService.findAdoptById(adoptId);
        adopt.setIsExamine(adopt.getIsExamine() == 0 ? 1 : 0);
        adoptService.save(adopt);
        return "redirect:adoptList";
    }

}
