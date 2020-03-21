package com.ivan.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Ivan
 * @Date: 2020/3/21 17:31
 * @Description:
 */
@Data
@NoArgsConstructor
/**
 * @TableName(value = "user"):指定数据库中的表名(二者相同时可以省略)
 */
//@TableName(value = "user")
public class User {
    /**
     * @TableId
     * value = "id":指定主键列名(二者相同时可以省略)
     * type = IdType.AUTO:主键策略使用数据库主键自增
     */
    //@TableId(value = "id", type = IdType.AUTO)//已再application.yml中进行全局配置
    private Integer id;
    /**
     * @TableField
     * value = "name":与数据库表中对应的列名(二者相同时可以省略)
     * exist = false:对象中有这个属性但数据库表中并没有这个列名,设置false可以在操作数据库时忽略这个属性
     */
    //@TableField(value = "name")
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
}
