package indi.midreamsheep.schatapp.backend.dao.mysql.handle.chat.user;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.dao.chat.UserMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.entity.DaoUserMap;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.UserMapMapper;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.UserMapper;
import indi.midreamsheep.schatapp.backend.service.dao.User;
import indi.midreamsheep.schatapp.backend.service.dao.UserMap;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserMapperHandlerImpl implements UserMapperHandler {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserMapMapper userMapMapper;

    @Override
    public SChatUser getUserById(long id) {
        log.info("用户id:{}", id);
        try {
            SChatUser user = new SChatUser();
            user.setUserData(BeanUtil.copyProperties(userMapper.selectById(id), User.class));
            user.setId(id);
            log.info("用户查询信息:{}", user);
            QueryWrapper<DaoUserMap> wrapper = new QueryWrapper<>();
            wrapper.eq("user_0", id).or(userMapQueryWrapper -> userMapQueryWrapper.eq("user_1", id));
            DaoUserMap[] userMaps = userMapMapper.selectList(wrapper).toArray(new DaoUserMap[0]);
            log.info("用户关系信息:{}", userMaps.toString());
            //将userMaps中的id放入long数组中
            long[] ids = new long[userMaps.length];
            for (int i = 0; i < userMaps.length; i++) {
                ids[i] = userMaps[i].getId();
            }
            user.setIndividuals(ids);
            //TODO 处理群组信息
            //TODO 处理频道信息
            return user;
        }catch (Exception e){
            throw new ChatException("the user is not exist");
        }
    }
}
