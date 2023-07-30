import indi.midreamsheep.schatapp.backend.until.gson.GsonUtil;

public class test {
    public static void main(String[] args) {
        Pojo pojo = GsonUtil.GsonToBean("{\"name\":\"name\",\"data\":{\"name\":SID,\"age\":18}}", Pojo.class);
        System.out.println(pojo);
    }
}
