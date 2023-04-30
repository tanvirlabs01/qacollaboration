package com.qacollaboration.utils.db;

import java.sql.SQLException;

public class DataBaseFactory {

    private static DataBaseUtil dbInstance = null;
    protected static DataBaseUtil getDataBase() throws SQLException {
            dbInstance = new MySqlImpl();
            //dbInstance = new MsSqlImpl();
        return dbInstance;
    }

}
