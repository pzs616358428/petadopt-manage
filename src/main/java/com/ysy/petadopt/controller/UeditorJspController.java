package com.ysy.petadopt.controller;

import com.qiniu.http.Response;
import com.ysy.petadopt.dto.PutRetDTO;
import com.ysy.petadopt.service.QiniuUploadFileService;
import com.ysy.petadopt.utils.UeditorVOUtils;
import com.ysy.petadopt.vo.UeditorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/ueditor/jsp/")
public class UeditorJspController {

    @Autowired
    private QiniuUploadFileService qiniuUploadFileService;

    @Value("${qiniu.cdn.prefix}")
    private String prefix;

    @RequestMapping("controller")
    public String getConfigInfo(String action) {
        // 读取配置文件请求
        if (action.equals("config")) {
            return "config";
        } else if (action.equals("uploadimage")) {
            return "uploadimage";
        }
        return "";
    }

    @GetMapping("config")
    @ResponseBody
    public String config() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("static/ueditor/jsp/config.json");
        byte[] buffer = new byte[inputStream.available()];
        String config = "";
        while (inputStream.read(buffer) != -1) {
            config += new String(buffer, "UTF-8");
        }
        return config;
    }

    @PostMapping("uploadimage")
    @ResponseBody
    public UeditorVO uploadimage(MultipartFile upfile) throws IOException {
        Response response = qiniuUploadFileService.uploadFile(upfile.getInputStream());
        PutRetDTO putRetDTO = response.jsonToObject(PutRetDTO.class);
        return UeditorVOUtils.success(prefix + "/" + putRetDTO.getKey(), upfile.getOriginalFilename(), upfile.getOriginalFilename());
    }

}
