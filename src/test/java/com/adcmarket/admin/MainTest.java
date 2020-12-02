package com.adcmarket.admin;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

    @Test
    public void testConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "test", "1234");

            System.out.println("DB 연결 성공 : " + conn);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
