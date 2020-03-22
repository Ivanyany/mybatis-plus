package com.ivan;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.ivan.bean.ar.User;
import com.ivan.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPlusApplicationTests {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 测试插入方法
	 */
	@Test
	public void testInsert(){

		com.ivan.bean.User user = new com.ivan.bean.User("张三",20,"zhangsan@ivan.com");

		//1.对象为空的属性,其对应的字段不会出现在SQL语句中
		Integer result = userMapper.insert(user);

		//2.不管对象的属性是否为空,其对应的字段都会出现在SQL语句中
		//Integer result1 = userMapper.insertAllColumn(user);

		System.out.println(result);

		//对象可以自动获取插入数据库后该列的主键值
		Integer id = user.getId();
		System.out.println(id);

	}

	/**
	 * 测试更新方法
	 */
	@Test
	public void testUpdate(){

		com.ivan.bean.User user = new com.ivan.bean.User();
		user.setId(5);
		user.setName("张三update");

		//1.对象为空的属性,其对应的字段不会出现在SQL语句中
		Integer result = userMapper.updateById(user);

		//2.不管对象的属性是否为空,其对应的字段都会出现在SQL语句中,空的属性会以null修改数据库(慎用!!)
		//Integer result1 = userMapper.updateAllColumnById(user);

		System.out.println(result);

	}

	/**
	 * 测试查询方法
	 */
	@Test
	public void testSelect() {
		//1.根据id查询
//		User user = userMapper.selectById(5);
//		System.out.println(user);

		//2.通过多个列名查询:id + name
//		User user1 = new User();
//		user1.setId(6);
//		user1.setName("张三");
//		//注意:这个方法只能查询一条结果,若查询结果为多条则会抛出异常
//		User resultUser = userMapper.selectOne(user1);
//		System.out.println(resultUser);

		//3.通过多个id查询
//		List<Integer> ids = new ArrayList<>();
//		ids.add(3);
//		ids.add(4);
//		ids.add(5);
//		List<User> userList = userMapper.selectBatchIds(ids);
//		System.out.println(userList);

		//4.通过Map封装条件查询(注意:columnMap里面的key必须是数据库表的列名,不能是对象的属性名,二者相同时均可)
//		Map<String, Object> columnMap = new HashMap<>();
//		columnMap.put("age", 18);
//		List<User> userList1 = userMapper.selectByMap(columnMap);
//		System.out.println(userList1);

		//5.分页查询(这是逻辑分页,不是物理分页(limit的形式),数据量很大是性能不好)
//		List<User> userPage = userMapper.selectPage(new Page<>(2, 3), null);
//		System.out.println(userPage);

		//6.查询所有
		List<com.ivan.bean.User> userList2 = userMapper.selectList(null);
		System.out.println(userList2);
	}

	@Test
	public void testDelete(){
		//1.根据id删除
//		Integer result = userMapper.deleteById(9);
//		System.out.println(result);

		//2.根据map封装条件删除
//		Map<String, Object> columnMap = new HashMap<>();
//		columnMap.put("name", "张三");
//		Integer result1 = userMapper.deleteByMap(columnMap);
//		System.out.println(result1);

		//3.根据多个id批量删除
		List<Integer> ids = new ArrayList<>();
		ids.add(4);
		ids.add(5);
		Integer result2 = userMapper.deleteBatchIds(ids);
		System.out.println(result2);
	}


	//*************************条件构造器*******************************

	/**
	 * 条件构造器
	 * 必须使用数据库中表的字段
	 */
	@Test
	public void tsetEntityWrapper(){

//		List<User> userList = userMapper.selectPage(new Page<>(1, 2),
//				new EntityWrapper<User>()
//						.between("age",18,24)
//						.like("email","ivan"));

		List<com.ivan.bean.User> userList = userMapper.selectPage(new Page<>(1, 2),
				Condition.create()
						.between("age",18,24)
						.like("email","ivan"));

		System.out.println(userList);

	}

	//*******************AR(Active Record)可以自己调用方法进行CRUD操作**********************
	@Test
	public void testARInsert(){
		User user = new User("李四",22,"lisi@ivan.com");
		boolean result = user.insert();
		System.out.println(result);
	}

}