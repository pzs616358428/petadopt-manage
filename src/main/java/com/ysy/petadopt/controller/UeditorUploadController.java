package com.ysy.petadopt.controller;

import com.qiniu.http.Response;
import com.ysy.petadopt.dto.PutRetDTO;
import com.ysy.petadopt.service.QiniuUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/ueditor/")
public class UeditorUploadController {

    @Autowired
    private QiniuUploadFileService qiniuUploadFileService;

    @Value("${qiniu.cdn.prefix}")
    private String prefix;

    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile image) throws IOException {
        Response response = qiniuUploadFileService.uploadFile(image.getInputStream());
        PutRetDTO putRetDTO = response.jsonToObject(PutRetDTO.class);
        return prefix + "/" + putRetDTO.getKey();
    }

}
