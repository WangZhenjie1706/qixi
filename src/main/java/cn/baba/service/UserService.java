package cn.baba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.baba.dao.UserDao;
import cn.baba.domain.User;

/**
 * 业务逻辑层
 * 
 * @version 1.0 created by wangzhenjie_fh on 2018年10月2日 下午2:31:10
 */
@Service
public class UserService {
    @Autowired
    private UserDao userRepositoty;

    public User findUserByName(String username) {
        User user = null;
        user = userRepositoty.findByUsername(username);
        return user;
    }

    public boolean login(String username, String password) {
        User user = userRepositoty.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public String doLogin(String username, String password) throws Exception {

        User user = userRepositoty.findByUsername(username);
        if (null == user) {
            // 用户不存在
            return null;
        }
        if (!password.equals(user.getPassword())) {
            // 密码错误
            return null;
        }

        // 登录成功
        return username;
    }
}
