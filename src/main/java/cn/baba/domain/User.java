package cn.baba.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 *
 * @version 1.0 created by wangzhenjie_fh on 2018年10月2日 下午2:22:17
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private String username;
    @JsonIgnore // 序列化时忽略该字段
    @Length(min = 6, max = 20, message = "密码的长度在6~20之间.")
    private String password;
}
