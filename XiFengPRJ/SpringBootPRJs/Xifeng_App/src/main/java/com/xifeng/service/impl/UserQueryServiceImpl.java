package com.xifeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xifeng.dao.UserMapper;
import com.xifeng.domain.entity.User;
import com.xifeng.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getOne(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);

        return userMapper.selectOne(wrapper);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectList(null);
    }
}
