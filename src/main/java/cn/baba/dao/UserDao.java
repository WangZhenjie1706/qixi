package cn.baba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.baba.domain.User;

/**
 *
 * @version 1.0 created by wangzhenjie_fh on 2018年10月2日 下午2:27:20
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("select t from User t where t.username = :username")
    User findByUsername(@Param("username") String Username);
}
