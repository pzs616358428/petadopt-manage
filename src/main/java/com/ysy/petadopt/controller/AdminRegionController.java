package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Region;
import com.ysy.petadopt.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/admin/adopt/")
public class AdminRegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("regionList")
    public String regionList(ModelMap modelMap) {
        modelMap.put("regionList", regionService.findAll());
        return "adopt/region_list";
    }

    @PostMapping("addRegion")
    public String addRegion(Region region) {
        region.setThemeCount(0);
        region.setPostCount(0);
        region.setLastTime(new Date());
        regionService.save(region);
        return "redirect:regionList";
    }

    @GetMapping("deleteRegion")
    public String deleteRegion(Integer id) {
        regionService.deleteById(id);
        return "redirect:regionList";
    }

}
