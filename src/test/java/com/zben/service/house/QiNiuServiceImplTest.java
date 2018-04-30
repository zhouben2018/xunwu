package com.zben.service.house;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.zben.DemoApplicationTests;
import com.zben.service.IQiNiuService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * @Author:zben
 * @Date: 2018/4/29/029 14:39
 */
public class QiNiuServiceImplTest extends DemoApplicationTests {

    @Autowired
    private IQiNiuService qiNiuService;

    @Test
    public void uploadFile() {
        String fileName = "D:\\mySoft\\idea-workspace\\test\\xunwu\\tmp\\3ac79f3df8dcd1007fde3f4e7e8b4710b9122f1b.jpg";
        File file = new File(fileName);

        Assert.assertTrue(file.exists());

        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

}