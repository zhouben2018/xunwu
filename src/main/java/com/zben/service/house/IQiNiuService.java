package com.zben.service.house;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * @Author:zben
 * @Date: 2018/4/29/029 14:29
 */
public interface IQiNiuService {

    public Response uploadFile(File file) throws QiniuException;

    public Response uploadFile(InputStream inputStream) throws QiniuException;

    public Response delete(String key) throws QiniuException;
}
