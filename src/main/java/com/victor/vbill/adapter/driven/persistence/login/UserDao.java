package com.victor.vbill.adapter.driven.persistence.login;

import com.victor.vbill.domain.login.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(User user) {
        jdbcTemplate.update("INSERT INTO USERS (user_name, created_date, created_by, updated_date, updated_by) " +
                "VALUES (?, ?, ?, ?, ?)", user.getUsername(), user.getCreatedDate(), user.getCreatedBy(),
                user.getUpdatedDate(), user.getUpdatedBy());
    }

    public List<User> findAllByUsername(String username) {
        return jdbcTemplate.query("SELECT * FROM USERS WHERE user_name = ?", new Object[]{username},
                (rs, rowNum) -> User.builder()
                        .id(rs.getLong(1))
                        .createdDate(rs.getLong(2))
                        .createdBy(rs.getString(3))
                        .updatedDate(rs.getLong(4))
                        .updatedBy(rs.getString(5))
                        .username(rs.getString(2))
                        .password(rs.getString(6))
                        .build());
    }

    public User findFirstByUsername(String username) {
        List<User> allUsers = findAllByUsername(username);
        if (ObjectUtils.isEmpty(allUsers)) {
            return null;
        }

        return allUsers.get(0);
    }
}
