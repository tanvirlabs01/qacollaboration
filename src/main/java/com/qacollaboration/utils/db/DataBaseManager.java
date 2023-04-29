package com.qacollaboration.utils.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DataBaseManager {
    public static List<Map<String,?>> selectResult(String query) throws SQLException {
        return DataBaseFactory.getDataBase().select(query);
    }
}
