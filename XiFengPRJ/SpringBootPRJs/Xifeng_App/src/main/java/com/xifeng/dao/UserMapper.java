package com.xifeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xifeng.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
