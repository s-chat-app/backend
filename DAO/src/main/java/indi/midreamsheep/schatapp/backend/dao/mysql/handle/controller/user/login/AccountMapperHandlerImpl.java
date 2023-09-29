package indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user.login;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import indi.midreamsheep.schatapp.backend.dao.controller.AccountMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.entity.DaoAccount;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.AccountMapper;
import indi.midreamsheep.schatapp.backend.service.dao.Account;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperHandlerImpl implements AccountMapperHandler {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getAccountByPwd(long userId, String password) {
        QueryWrapper<DaoAccount> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("pwd", password);
        return BeanUtil.copyProperties(accountMapper.selectOne(wrapper), Account.class);
    }

    @Override
    public Account getAccountByToken(String token) {
        QueryWrapper<DaoAccount> wrapper = new QueryWrapper<>();
        wrapper.eq("token", token);
        return BeanUtil.copyProperties(accountMapper.selectOne(wrapper),Account.class);
    }
}
