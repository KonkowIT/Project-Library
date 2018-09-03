package com.crud.library.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class DatabaseManagerTestSuite {
    @Test
    public void testConnection() throws SQLException {
        //given
        //when
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        //then
        assertNotNull(databaseManager.getConnection());
    }
}
