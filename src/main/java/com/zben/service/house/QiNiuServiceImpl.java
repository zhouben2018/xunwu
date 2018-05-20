package com.zben.service.house;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * @Author:zben
 * @Date: 2018/4/29/029 14:31
 */
@Service
public class QiNiuServiceImpl implements IQiNiuService, InitializingBean {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Value("${qiniu.Bucket}")
    private String bucket;

    private StringMap putPolicy;

    @Override
    public Response uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file, null, getUploadToken());
        int retry = 0;
        if (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(file, null, getUploadToken());
        }
        return response;
    }

    @Override
    public Response uploadFile(InputStream inputStream) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry = 0;
        if (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }
        return response;
    }

    @Override
    public Response delete(String key) throws QiniuException {
        Response response = bucketManager.delete(this.bucket, key);
        int retry = 0;
        if (response.needRetry() && retry < 3) {
            response = bucketManager.delete(this.bucket, key);
            retry++;
        }
        return response;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\"" +
                ",\"width\":$(imageInfo.width),\"height\":\"${imageInfo.height}\"}");
    }

    /**
     * 获取上传凭证
     * @return
     */
    private String getUploadToken() {
        return this.auth.uploadToken(bucket, null, 3600, putPolicy);
    }
}
