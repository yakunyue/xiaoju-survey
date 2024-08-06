package com.xiaojusurvey.engine.core.user.impl;

import com.xiaojusurvey.engine.common.entity.User;
import com.xiaojusurvey.engine.core.user.UserService;
import com.xiaojusurvey.engine.repository.MongoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private MongoRepository mongoRepository;

    @Override
    public List<User> findAllUser() {
        if (true)
        throw new RuntimeException("test GlobalExceptionHandler");
        return mongoRepository.findAll(User.class);
//        final User user = new User();
//        user.setUsername("aaa");
//        return Collections.singletonList(user);
    }
}
