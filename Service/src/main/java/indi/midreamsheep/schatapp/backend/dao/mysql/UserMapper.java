package indi.midreamsheep.schatapp.backend.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends  BaseMapper<User> {
}
