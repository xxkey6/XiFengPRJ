package com.xifeng.service;

import com.xifeng.domain.entity.User;

public interface UserManipulationService {

    boolean insert(User user);

    boolean update(User user);

    boolean delete(Integer id);
}
