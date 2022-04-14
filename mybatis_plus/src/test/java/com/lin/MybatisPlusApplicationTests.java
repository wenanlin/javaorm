package com.lin;

import com.lin.com.lin.pojo.User;
import com.lin.com.lin.pojo.com.lin.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;


    /**
     * ====插入
     */
    @Test
    public void testInsert() {
        for (int i = 0; i < 2; i++) {
            User user = new User(null, "张三", 23, "zhangsan@atguigu.com");
            final int insert = userMapper.insert(user);
        }
    }

    /**
     * 通过id删除记录
     */
    @Test
    public void testDeleteById() {
        //通过id删除用户信息
        //DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1514636055459807233L);
        System.out.println("受影响行数：" + result);
    }

    /**
     * 通过id删除记录
     */
    @Test
    public void testDeleteBatchIds() {
        final int i = userMapper.deleteBatchIds(Arrays.asList(1514636610034876417L, 1514636611599351810L));
        System.out.println("testDeleteBatchIds:" + i);
    }


    @Test
    public void testDeleteByMap() {
        //根据map集合中所设置的条件删除记录
        //DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
//        map.put("age", 23);
        map.put("name", "张三");
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响行数：" + result);
    }

    /**
     * 修改
     */


    @Test
    public void testUpdateById() {
        User user = new User(1514636610034876417L, "张三", 24, null);
        //UPDATE user SET name=?, age=? WHERE id=?
        int result = userMapper.updateById(user);
        System.out.println("受影响行数：" + result);
    }

    /**
     * 查询
     */
    @Test
    public void testSelectList() {
//        userMapper.selectList(null).forEach(System.out::println);
//        userMapper.selectById("1");
        userMapper.selectList(null).forEach(System.out::println);
    }

    /**
     * 根据id查询用户信息
     */
    @Test
    public void testSelectById() {
        final User user = userMapper.selectById(1514636610034876417L);
        System.out.println(user);

    }

    /**
     * 根据多个id查询多个用户信息
     */
    @Test
    public void testSelectBatchIds() {
        userMapper.selectBatchIds
                (Arrays.asList(1514636610034876417L, 1514636611599351810L)).forEach(System.out::println);
    }
    /**
     * 通过map条件查询用户信息
     */
    @Test
    public void selectByMap() {

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("age",24);
//        map.put("","");

        userMapper.selectByMap(map).forEach(System.out::println);
    }


}
