package com.ivan.auto.service.impl;

import com.ivan.auto.beans.User;
import com.ivan.auto.mapper.UserMapper;
import com.ivan.auto.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ivan
 * @since 2020-03-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //extends ServiceImpl<UserMapper, User>以后不用再进行mapper注入
    /**
     * UserServiceImpl 继承了ServiceImpl
     *  1.在ServiceImpl中已经完成了Mapper对象的注入,直接在UserServiceImpl中进行使用
     *  2.在ServiceImpl中也帮我们提供了常用的CRUD方法,基本的一些CRUD方法在Service中不需要自己定义
     */
}
