package com.exler.bos.dao.impl;

import com.exler.bos.dao.UserDao;
import com.exler.bos.dao.base.impl.BaseDaoImpl;
import com.exler.bos.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
