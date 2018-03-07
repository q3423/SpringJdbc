package com.lm.util;

import com.lm.dao.impl.StudentDaoSpringJdbcImpl;
import com.lm.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Title: JDBCTeplateTest
 * @Author:LiMan
 * @Date:2018/3/7 16:09
 * @Description:
 */
public class JDBCTeplateTest {
    private ApplicationContext ctx = null;

    @Before
    public void setLoad() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @After
    public void clearLoad() {
        ctx = null;
    }

    @Test
    public void dataSourceTest() {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void jdbcTemplateTest() {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
    }

    @Test
    public void studentDaoTemplateTest() {
        StudentDaoSpringJdbcImpl studentDaoSpringJdbc = (StudentDaoSpringJdbcImpl)ctx.getBean("studentDaoSpringJdbcImpl");
        java.util.List<Student> list = studentDaoSpringJdbc.query();
        for (Student stu : list
                ) {
            System.out.println(stu);
        }
    }
}
