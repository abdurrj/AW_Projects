package com.cr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class CustomerRepository {

    @Autowired
    DataSource dataSource;

    public int getCustomerCount() {
        int count = 0;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT count(*) AS C FROM CUSTOMER")) {
            if (rs.next()) {
                count = rs.getInt("C");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
