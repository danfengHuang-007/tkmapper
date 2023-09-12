package com.qfedu.tkmapperdemo.dao;

import com.qfedu.tkmapperdemo.TkmapperDemoApplication;
import com.qfedu.tkmapperdemo.beans.Category;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TkmapperDemoApplication.class)
public class CategoryDAOTest {
    @Autowired
    private CategoryDAO categoryDAO;

    @Test
    public void testInsert(){
        //Category category = new Category(0,"测试类别1",1,0,"01.png","hehe","aaa.jpg","black");
       // int i = categoryDAO.insert(category);
        Category category = new Category(0,"测试类别2",1,0,"02.png","haha","aaa.jpg","black");
        int i = categoryDAO.insertUseGeneratedKeys(category);
        System.out.println(category.getCategoryId());
        assertEquals(1,i);
    }

    @Test
    public void testUpdate(){
        Category category = new Category(48,"测试类别4",1,0,"04.png","heihei","aaa.jpg","black");
        int i = categoryDAO.updateByPrimaryKey(category);
        assertEquals(1,i);
    }

    @Test
    public void testDelete(){
        int i = categoryDAO.deleteByPrimaryKey(48);
        assertEquals(1,i);
    }

    @Test
    public void testSelect1(){
        // 查询所有
        List<Category> categories = categoryDAO.selectAll();
        for (Category category: categories){
            System.out.println(category);
        }
    }

    @Test
    public void testSelect2(){
        // 根据主键查询
        Category category = categoryDAO.selectByPrimaryKey(47);
        System.out.println(category);
    }

    @Test
    public void testSelect3(){
        //根据条件查询
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryLevel",1);
        criteria.andLike("categoryName","%干%");
        //criteria.orEqualTo("categoryLevel",2);
        List<Category> categories = categoryDAO.selectByExample(example);
    }

    @Test
    public void testSelect4(){
        //分页查询
        int pageNum = 2;
        int pageSize = 10;
        int start = (pageNum-1) * pageSize;

        RowBounds rowBounds = new RowBounds(start,pageSize);
        List<Category> categories = categoryDAO.selectByRowBounds(new Category(),rowBounds);
        for (Category category: categories){
            System.out.println(category);
        }
        // 查询总记录数
        int i = categoryDAO.selectCount(new Category());
        System.out.println(i);
    }

    @Test
    public void testSelect5(){
        // 带条件分页
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryLevel",1);

        int pageNum = 1;
        int pageSize = 3;
        int start = (pageNum-1) * pageSize;
        RowBounds rowBounds = new RowBounds(start,pageSize);

        List<Category> categories = categoryDAO.selectByExampleAndRowBounds(example,rowBounds);
        for (Category category: categories){
            System.out.println(category);
        }

        // 查询满足条件的记录数
        int i = categoryDAO.selectCountByExample(example);
        System.out.println(i);
    }

}