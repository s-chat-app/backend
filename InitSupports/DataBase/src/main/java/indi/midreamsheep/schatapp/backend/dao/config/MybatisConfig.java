package indi.midreamsheep.schatapp.backend.dao.config;

import org.mybatis.spring.annotation.MapperScan;

/*扫描指定包下的mapper*/
@MapperScan("indi.midreamsheep.schatapp.backend.dao.mysql")
public class MybatisConfig {
}
