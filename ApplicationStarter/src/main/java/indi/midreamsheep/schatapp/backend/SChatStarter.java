package indi.midreamsheep.schatapp.backend;

import cn.hutool.core.io.IoUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * SChat的启动类,通过读取starters/START.schat文件内的内容来对SChat进行配置
 * */
public class SChatStarter {
    public static void main(String[] args) throws IOException {
        List<Class<?>> classes = new LinkedList<>();
        classes.add(ApplicationStarter.class);
        //读取starters/START.schat文件内的内容
        InputStream inputStream = SChatStarter.class.getClassLoader().getResourceAsStream("starters/START.schat");
        assert inputStream != null:"could not find START.schat file";
        //读取文件
        IoUtil.getUtf8Reader(inputStream).lines()
                .forEach((in)->{
                    try {
                        Class<?> aClass = Class.forName(in.trim());
                        classes.add(aClass);
                    } catch (ClassNotFoundException e) {
                        System.err.println("class not found:"+in);
                    }
                });
        inputStream.close();
        ApplicationStarter.start(classes.toArray(new Class<?>[0]),args);

    }
}
