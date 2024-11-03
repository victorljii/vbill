package com.victor.vbill;

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

    @Override
    public void run(String... args) throws Exception {
        showConnection();
    }

    private void showConnection() throws SQLException {
        log.info("data source: {}", dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info("connection: {}", conn.toString());
        conn.close();
    }
}
