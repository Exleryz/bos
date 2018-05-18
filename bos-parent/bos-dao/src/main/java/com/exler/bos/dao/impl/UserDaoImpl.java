package com.exler.bos.dao.impl;

import com.exler.bos.dao.UserDao;
import com.exler.bos.dao.base.impl.BaseDaoImpl;
import com.exler.bos.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    /**
     * 根据用户名密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String hql = "from com.exler.bos.domain.User u where u.username = ? and u.password = ?";    // 为什么必须得写全路径？
        List<User> list = (List<User>) getHibernateTemplate().find(hql, username, password);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
