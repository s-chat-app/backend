package indi.midreamsheep.schatapp.backend;

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
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(userMapper.selectById(5));
    }
}
