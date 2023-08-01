import indi.midreamsheep.schatapp.backend.dao.mysql.User;
import indi.midreamsheep.schatapp.backend.dao.mysql.UserMapper;
import jakarta.annotation.Resource;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MysqlTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void test() {
        userMapper.insert(new User(5,"asda"));
    }
}
