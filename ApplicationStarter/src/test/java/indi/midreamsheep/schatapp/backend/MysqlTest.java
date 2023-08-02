package indi.midreamsheep.schatapp.backend;

import indi.midreamsheep.schatapp.backend.dao.mysql.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MysqlTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void test() {
        System.out.println("hello");
        System.out.println(userMapper.selectById(5));
    }
}
