package com.lm.dao.impl;

import com.lm.dao.StudentDao;
import com.lm.domain.Student;
import com.lm.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *@Title: StudentDaoImpl
 *@Author:LiMan
 *@Date:2018/3/7 14:27
 *@Description: 
 */
public class StudentDaoImpl implements StudentDao{
    public List<Student> query() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = JDBCUtil.getConnection();
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Student> list = new ArrayList<Student>();
            while (resultSet.next()){
                long id = resultSet.getLong("student_id");
                String studentName = resultSet.getString("student_name");
                int studentAge = resultSet.getInt("student_age");
                String gender = resultSet.getString("gender");
                Student student = new Student(id,studentName,studentAge,gender);
                list.add(student);
            }
            return list;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.release(resultSet,preparedStatement,connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

