package indi.midreamsheep.schatapp.backend.controller.user;


import indi.midreamsheep.schatapp.backend.config.SChatConfig;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.Result;
import indi.midreamsheep.schatapp.backend.protocol.chat.resonse.data.result.login.LoginResultEnum;
import indi.midreamsheep.schatapp.backend.service.controller.user.LoginService;
import indi.midreamsheep.schatapp.backend.service.service.controller.user.login.LoginTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @Resource
    private LoginService loginService;

    @Resource
    private SChatConfig sChatConfig;

    @ResponseBody
    @PostMapping("/login/pwd")
    public String loginByPwd(long userId, String password) {
        if(sChatConfig.getLoginType()!= LoginTypeEnum.PWD){
            return notSupportLoginType().toString();
        }
        return loginService.loginByPwd(userId, password);
    }

    @ResponseBody
    @PostMapping("/login/token")
    public String loginByToken(String token) {
        if(sChatConfig.getLoginType()!= LoginTypeEnum.TOKEN){
            return notSupportLoginType().toString();
        }
        return loginService.loginByToken(token);
    }

    @ResponseBody
    @PostMapping("/login/server")
    public String loginByServer(String serverToken) {
        if(sChatConfig.getLoginType()!= LoginTypeEnum.SERVER){
            return notSupportLoginType().toString();
        }
        return loginService.loginByServer(serverToken);
    }

    private Result notSupportLoginType(){
        return new Result(LoginResultEnum.NOT_SUPPORT_LOGIN_TYPE,"should use type "+sChatConfig.getLoginType().getName());
    }
}
