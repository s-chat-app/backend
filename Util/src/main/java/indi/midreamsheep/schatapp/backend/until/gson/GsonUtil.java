package indi.midreamsheep.schatapp.backend.until.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class GsonUtil {

    private static final Gson gson = new Gson();
    private GsonUtil() {}

    public static String GsonToString(Object object) {
        return gson.toJson(object);
    }

    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        return gson.fromJson(gsonString, cls);
    }


    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        return gson.fromJson(gsonString, new TypeToken<List<T>>() {}.getType());
    }

    public static <T> List<T> JsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }

    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        return gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>(){}.getType());
    }

    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        return gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {}.getType());
    }

    public static String BeanToJson(Object object){
        return gson.toJson(object);
    }

}