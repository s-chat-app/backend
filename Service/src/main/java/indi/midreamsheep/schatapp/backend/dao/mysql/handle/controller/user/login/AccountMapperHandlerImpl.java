package indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import indi.midreamsheep.schatapp.backend.dao.mysql.handle.controller.user.AccountMapperHandler;
import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.AccountMapper;
import indi.midreamsheep.schatapp.backend.service.dao.mysql.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperHandlerImpl implements AccountMapperHandler {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getAccountByPwd(long userId, String password) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("pwd", password);
        return accountMapper.selectOne(wrapper);
    }

    @Override
    public Account getAccountByToken(String token) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("token", token);
        return accountMapper.selectOne(wrapper);
    }
}
