package com.ysy.petadopt.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.InputStream;

public interface QiniuUploadFileService {

    /**
     * 以流的形势上传
     * @param inputStream
     * @return
     */
    Response uploadFile(InputStream inputStream) throws QiniuException;

    /**
     * 删除文件
     * @param key
     * @return
     */
    Response delete(String key) throws QiniuException;

}
