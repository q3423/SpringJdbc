package com.lm.dao.impl;

import com.lm.dao.StudentDao;
import com.lm.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *@Title: StudentDaoSpringJdbcImpl
 *@Author:LiMan
 *@Date:2018/3/7 16:17
 *@Description: 
 */
public class StudentDaoSpringJdbcImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    public List<Student> query() {
        String sql = "select * from student";
        final List<Student> list = new ArrayList<Student>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                long id = resultSet.getLong("student_id");
                String studentName = resultSet.getString("student_name");
                int studentAge = resultSet.getInt("student_age");
                String gender = resultSet.getString("gender");
                Student student = new Student(id,studentName,studentAge,gender);
                list.add(student);
            }
        });
        return list;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
