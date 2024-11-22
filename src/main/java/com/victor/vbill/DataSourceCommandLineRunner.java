package com.victor.vbill;

import com.victor.vbill.adapter.driven.persistence.login.UserDao;
import com.victor.vbill.domain.login.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// CommandLineRunner 负责在 Spring Boot 应用程序启动后执行初始化操作
@Slf4j
@Component
public class DataSourceCommandLineRunner implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        User Foo = new User("victor", "abc");
        Foo.applyAuditInfoOnCreate("victor");
        log.info("insert foo: {}", Foo);
        userDao.insertUser(Foo);
    }

    // 测试方法
    private void showConnection() throws SQLException {
        log.info("data source: {}", dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info("connection: {}", conn.toString());
        conn.close();
    }
}
