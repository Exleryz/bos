package com.exler.bos.service;

import com.exler.bos.domain.User;

public interface UserService {
    User login(User user);

    void editPassword(String id, String password);
}
