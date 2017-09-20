package com.hls.springboot.security.dao;

import com.hls.springboot.security.bean.Users;

import java.util.List;

public interface UsersMapper {
    public List<Users> query();

    Users loginQuery(Users user);
}
