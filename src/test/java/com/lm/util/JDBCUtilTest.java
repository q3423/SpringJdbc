package com.lm.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by asus on 2018/3/7.
 */
public class JDBCUtilTest {
    @Test
    public void testGetConnection() throws Exception{
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}