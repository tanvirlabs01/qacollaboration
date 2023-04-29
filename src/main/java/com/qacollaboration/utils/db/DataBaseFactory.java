package com.qacollaboration.utils.db;

import core.utils.Config;

import java.sql.SQLException;

public class DataBaseFactory {

    private static DataBaseUtil dbInstance = null;
    protected static DataBaseUtil getDataBase() throws SQLException {
        if(Config.getDB().equalsIgnoreCase("greywaveqadb"))
        {
            dbInstance = new MySqlImpl();
        }
        if(Config.getEnv().equalsIgnoreCase("zealousriverdb"))
        {
            dbInstance = new MsSqlImpl();
        }
        return dbInstance;
    }

}
