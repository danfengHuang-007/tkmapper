package com.qfedu.tkmapperdemo.dao;


import com.qfedu.tkmapperdemo.TkmapperDemoApplication;
import com.qfedu.tkmapperdemo.beans.Orders;
import com.qfedu.tkmapperdemo.beans.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TkmapperDemoApplication.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Test
    public void test(){
        User user = new User();
        user.setUsername("aaaa");
        user.setPassword("1111");
        user.setUserImg("img/default.png");
        user.setUserRegtime(new Date());
        user.setUserModtime(new Date());
        int i = userDAO.insert(user);
    }

    @Test
    public void testSelect(){
        /*
        // 查询用户同时查询订单
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username","zhangsan");

        // 根据用户名查询用户
        //1.先根据用户名查询用户信息
        List<User> users = userDAO.selectByExample(example);
        User user = users.get(0);
        // 2.再根据用户id到订单表查询订单
        Example example1 = new Example(Orders.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("userId",user.getUserId());
        List<Orders> ordersList = orderDAO.selectByExample(example1);
        // 3.将查询到订单集合设置到user
        user.setOrdersList(ordersList);
        System.out.println(user.getOrdersList());

         */
        // 自定义查询
        User user = userDAO.selectByUsername("zhangsan");
        System.out.println(user);
    }




}