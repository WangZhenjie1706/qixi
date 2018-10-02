package cn.baba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.baba.dao.UserDao;

/**
 * 用户控制
 * 
 * @version 1.0 created by wangzhenjie_fh on 2018年10月2日 下午2:17:09
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/nihao", method = RequestMethod.POST)
    public String name() {
        return userDao.findOne(1L).getUsername();
    }
}
