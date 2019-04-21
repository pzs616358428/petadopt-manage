package com.ysy.petadopt.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.ysy.petadopt.service.QiniuUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class QiniuUploadFileServiceImpl implements QiniuUploadFileService {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    private StringMap putPolicy;

    @Value("${qiniu.Bucket}")
    private String bucket;

    @Override
    public Response uploadFile(InputStream inputStream) throws QiniuException {
        afterPropertiesSet();
        Response response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }
        return response;
    }

    @Override
    public Response delete(String key) throws QiniuException {
        Response response = bucketManager.delete(bucket, key);
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = bucketManager.delete(bucket, key);
            retry++;
        }
        return response;
    }

    private void afterPropertiesSet() {
        putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
        putPolicy.put("saveKey", UUID.randomUUID().toString());
    }

    private String getUploadToken() {
        return auth.uploadToken(bucket, null, 3600, putPolicy);
    }

}
