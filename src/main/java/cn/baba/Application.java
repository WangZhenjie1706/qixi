package cn.baba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @version 1.0 created by wangzhenjie_fh on 2018年10月2日 下午2:13:26
 */

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "cn.baba.dao" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
