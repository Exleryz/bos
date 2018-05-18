package com.exler.bos.service.impl;

import com.exler.bos.dao.UserDao;
import com.exler.bos.domain.User;
import com.exler.bos.service.UserService;
import com.exler.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional    // 事务注解
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        // 使用md5加密密码
//        String password = MD5Utils.md5(user.getPassword());
//        return userDao.findUserByUsernameAndPassword(user.getUsername(), password());
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
