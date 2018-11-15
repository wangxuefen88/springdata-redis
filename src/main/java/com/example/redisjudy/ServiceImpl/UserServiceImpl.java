package com.example.redisjudy.ServiceImpl;


import com.example.redisjudy.model.User;
import com.example.redisjudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
* @Description:    封装reids中数据操作的服务接口
* @Author:         王雪芬
* @CreateDate:     2018/11/14 14:39
* @UpdateUser:     王雪芬
* @UpdateDate:     2018/11/14 14:39
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class UserServiceImpl implements UserService {

    //声明一个ke0y
    public static final String USERKEY="user";

    private HashOperations<String,Object,Object> operations;

    @Autowired
    private RedisTemplate<String ,User> redisTemplate;

    @PostConstruct
    public void initOperation(){
        this.operations=redisTemplate.opsForHash();
    }
    @Override
    public User save(User user) {
        this.operations.put(USERKEY,user.getId(),user);
        return user;
    }

    @Override
    public User findById(String id) {
        return (User) this.operations.get(USERKEY,id);
    }

    @Override
    public User update(User user) {
        save(user);
        return user;
    }



    @Override
    public void delete(String id) {
       this.operations.delete(USERKEY,id);
    }

}
