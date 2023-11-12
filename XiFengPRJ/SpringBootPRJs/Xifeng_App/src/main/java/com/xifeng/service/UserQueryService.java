package com.xifeng.service;

import com.xifeng.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserQueryService {
    User getOne(String username);

    List<User> getAll();
}
