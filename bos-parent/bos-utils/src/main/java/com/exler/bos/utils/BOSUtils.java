package com.exler.bos.utils;

import com.exler.bos.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Exler
 * @Date: 2018/5/19 09:05
 * @Description: BOS项目工具类
 */
public class BOSUtils {

    /**
     * 获得session对象
     * @return
     */
    public static HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 获取登录用户对象
     */
    public static User getLoginUser() {
        return (User) getSession().getAttribute("loginUser");
    }
}
