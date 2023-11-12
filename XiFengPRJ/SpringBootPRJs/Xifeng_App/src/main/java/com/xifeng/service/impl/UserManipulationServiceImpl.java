package com.xifeng.service.impl;

import com.xifeng.dao.UserMapper;
import com.xifeng.domain.entity.User;
import com.xifeng.service.UserManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManipulationServiceImpl implements UserManipulationService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insert(User user) {
        return userMapper.insert(user) == 1;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateById(user) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteById(id) == 1;
    }
}
