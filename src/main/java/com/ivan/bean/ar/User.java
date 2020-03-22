package com.ivan.bean.ar;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: Ivan
 * @Date: 2020/3/22 15:37
 * @Description:
 */
@Data
@NoArgsConstructor
//extends Model以后以后可以自己调用方法进行CRUD操作
public class User extends Model<User> {
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 自定义构造方法
     * @param name
     * @param age
     * @param email
     */
    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    /**
     * 返回主键对应的属性
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return id;
    }
}
