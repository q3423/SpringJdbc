package com.lm.dao.impl;

import com.lm.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by asus on 2018/3/7.
 */
public class StudentDaoImplTest {

    @Test
    public void query() throws Exception {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.query();
        for (Student stu: list) {
            System.out.println(stu);
        }
    }

}