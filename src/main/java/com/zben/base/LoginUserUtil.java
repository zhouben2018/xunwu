package com.zben.base;

import com.zben.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author:zben
 * @Date: 2018/4/30/030 11:38
 */
public class LoginUserUtil {

    public static User load() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null && principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

    public static Long getLoginUserId() {
        User user = load();
        if (user == null) {
            return -1L;
        }
        return user.getId();
    }
}
