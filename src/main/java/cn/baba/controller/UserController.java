package cn.baba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.baba.domain.User;
import cn.baba.service.UserService;

/**
 * 用户控制
 * 
 * @version 1.0 created by wangzhenjie_fh on 2018年10月2日 下午2:17:09
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public String show(@RequestParam(value = "username") String username) {
        User user = userService.findUserByName(username);
        if (null != user) {
            return user.getId() + "/" + user.getUsername() + "/" + user.getPassword();
        } else {
            return "null";
        }
    }
}
