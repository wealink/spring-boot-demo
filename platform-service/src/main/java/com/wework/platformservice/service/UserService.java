package com.wework.platformservice.service;

import com.wework.platformservice.bean.User;
import com.wework.platformservice.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDao {
    @Autowired
    private UserDao userDao;
    @Override
    public List getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
