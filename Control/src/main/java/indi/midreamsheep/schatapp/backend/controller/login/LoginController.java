package indi.midreamsheep.schatapp.backend.controller.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @ResponseBody
    @PostMapping("/login/user")
    public String loginByUser(String username, String password) {
        //TODO 通过用户名和密码登录
        return "login";
    }

    @ResponseBody
    @PostMapping("/login/key")
    public String loginByKey(String key) {
        //TODO 通过服务中心的公钥登录
        return "register";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String logout(long id) {
        //TODO 通过id注销
        return "logout";
    }




}
