package com.lin;

import com.lin.com.lin.pojo.com.lin.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectList() {
        userMapper.selectList(null).forEach(System.out::println);
    }

}
