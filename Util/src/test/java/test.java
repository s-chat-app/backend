import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import indi.midreamsheep.schatapp.backend.until.json.JsonUtil;

public class test {
    public static void main(String[] args) {
        Pojo pojo = JSON.parseObject("{\"name\":\"name\",\"data\":{\"name\":\"SID\",\"age\":18}}", Pojo.class);
        System.out.println(pojo.toString());
    }
}
