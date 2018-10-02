package cn.baba.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/login")
    public String index() {
        return "user/login";
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

    /**
     * 登录
     * 
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doLogin(@ModelAttribute User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            String token = this.userService.doLogin(user.getUsername(), user.getPassword());
            if (StringUtils.isEmpty(token)) {
                // 登录失败
                result.put("status", 500);
                return result;
            }
            // 登录成功，保存token到cookie
            result.put("status", 200);
        } catch (Exception e) {
            e.printStackTrace();
            // 登录失败
            result.put("status", 500);
        }
        return result;
    }
}
