package indi.midreamsheep.schatapp.backend.dao.mysql.handle.chat.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import indi.midreamsheep.schatapp.backend.api.chat.exception.ChatException;
import indi.midreamsheep.schatapp.backend.chat.account.SChatUser;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.chat.UserMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.UserMapMapper;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.UserMapper;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.UserMap;
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
            user.setUserData(userMapper.selectById(id));
            user.setId(id);
            log.info("用户查询信息:{}", user);
            QueryWrapper<UserMap> wrapper = new QueryWrapper<>();
            wrapper.eq("user_0", id).or(userMapQueryWrapper -> userMapQueryWrapper.eq("user_1", id));
            UserMap[] userMaps = userMapMapper.selectList(wrapper).toArray(new UserMap[0]);
            log.info("用户关系信息:{}", userMaps);
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
