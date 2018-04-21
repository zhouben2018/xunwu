package com.zben.repository;

import com.zben.DemoApplicationTests;
import com.zben.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:zben
 * @Date: 2018/4/21/021 10:53
 */
public class UserRepositoryTest extends DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOne() throws Exception {
        Long id = 1L;
        User u = userRepository.findOne(id);
        Assert.assertNotNull(u);
    }

}