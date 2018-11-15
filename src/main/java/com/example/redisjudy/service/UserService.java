package com.example.redisjudy.service;


import com.example.redisjudy.model.User;

/**
* @Description:   接口
* @Author:         王雪芬
* @CreateDate:     2018/11/14 14:42
* @UpdateUser:     王雪芬
* @UpdateDate:     2018/11/14 14:42
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface UserService {
    public User save(User user);
    public User findById(String id);
    public User update(User user);
    public void delete(String id);
}
