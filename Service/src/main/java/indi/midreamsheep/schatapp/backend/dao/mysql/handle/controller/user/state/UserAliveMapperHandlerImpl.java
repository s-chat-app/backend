package indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user.state;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user.UserAliveMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.UserAliveMapper;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.UserAlive;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserAliveMapperHandlerImpl implements UserAliveMapperHandler {

    @Resource
    private UserAliveMapper userAliveMapper;

    @Override
    public void addUser(long id,String privateKey) {
        userAliveMapper.insert(new UserAlive(id,privateKey));
    }

    @Override
    public long getUserId(String privateKey) {
        QueryWrapper<UserAlive> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("private_key",privateKey);
        UserAlive userAlive = userAliveMapper.selectOne(queryWrapper);
        if (userAlive != null) {
            return userAlive.getUserId();
        }
        return -1;
    }

    @Override
    public void deleteUser(String privateKey, long id) {
        QueryWrapper<UserAlive> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("private_key",privateKey).eq("user_id",id);
        userAliveMapper.delete(queryWrapper);
    }
}
