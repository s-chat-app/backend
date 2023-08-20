import cn.hutool.core.util.IdUtil;
import org.springframework.util.DigestUtils;

public class tsd {
    public static void main(String[] args) {
        System.out.println(IdUtil.fastSimpleUUID());
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(DigestUtils.md5DigestAsHex((IdUtil.fastSimpleUUID() + "123456645").getBytes()));
        }
        System.out.println(System.currentTimeMillis() - l);
    }
}
