package com.hls.springboot.security.service;

import com.hls.springboot.security.bean.Users;
import com.hls.springboot.security.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> query() {
        return usersMapper.query();
    }

    @Override
    public Users loginQuery(Users user) {
        return usersMapper.loginQuery(user);
    }
}
