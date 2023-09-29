package indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user.state;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import indi.midreamsheep.schatapp.backend.dao.controller.UserAliveMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.entity.DaoUserAlive;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.UserAliveMapper;
import indi.midreamsheep.schatapp.backend.service.dao.UserAlive;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserAliveMapperHandlerImpl implements UserAliveMapperHandler {

    @Resource
    private UserAliveMapper userAliveMapper;

    @Override
    public void addUser(long id,String privateKey) {
        userAliveMapper.insert(new DaoUserAlive(id,privateKey));
    }

    @Override
    public long getUserId(String privateKey) {
        QueryWrapper<DaoUserAlive> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("private_key",privateKey);
        UserAlive userAlive = BeanUtil.copyProperties(userAliveMapper.selectOne(queryWrapper),UserAlive.class);
        if (userAlive != null) {
            return userAlive.getUserId();
        }
        return -1;
    }

    @Override
    public void deleteUser(String privateKey, long id) {
        QueryWrapper<DaoUserAlive> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("private_key",privateKey).eq("user_id",id);
        userAliveMapper.delete(queryWrapper);
    }
}
