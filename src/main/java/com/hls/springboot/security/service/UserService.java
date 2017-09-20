package com.hls.springboot.security.service;

import com.hls.springboot.security.bean.Users;

import java.util.List;

public interface UserService {
    public List<Users> query();

    Users loginQuery(Users user);
}
