package com.qacollaboration.utils.db;

import core.utils.Config;

import java.sql.*;
import java.util.*;

public class MySqlImpl implements DataBaseUtil{

    private static MySqlImpl instance;
    public static String mySqlDriver = Config.getMySqlDbConnectionDriverClass();
    public static String mySqlHostName = Config.getMySqlDbHost();
    public static String mySqlUserName = Config.getMySqlDbUser();
    public static String mySqlPassword = Config.getMySqlDbPassword();
    public static String mySqlDbName = Config.getMySqlDbName();
    public static String mySqlDbPort = Config.getMySqlDbPort();
    private static Statement statement;
    private Connection connection;
    private ResultSet resultSet;

    public static void main(String[] args) throws SQLException {
        MySqlImpl mySql = new MySqlImpl();
        List<Map<String,?>> result= mySql.select("SELECT * FROM address WHERE ADDRESS_ID = 2");
        System.out.println(result.get(0).get("ADDR_LINE_0"));
        System.out.println(result.get(0).get("ADDR_LINE_1"));
    }
    protected MySqlImpl() throws SQLException {
        String connectionUrl = "jdbc:mysql://" + mySqlHostName + ":" + mySqlDbPort + "/" + mySqlDbName;
        try{
            Class.forName(mySqlDriver);
            this.connection = DriverManager.getConnection(connectionUrl,mySqlUserName, mySqlPassword);
        }catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }
    private Connection getConnection()
    {
        return this.connection;
    }
    protected static MySqlImpl getInstance() throws SQLException {
        if(Objects.nonNull(instance))
        {
            instance = new MySqlImpl();
        }else if(instance.getConnection().isClosed())
        {
            instance = new MySqlImpl();
        }
        return instance;
    }
    @Override
    public List<Map<String, ?>> select(String query) {
        List<Map<String,?>> results = new ArrayList<Map<String,?>>();
        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int column = resultSetMetaData.getColumnCount();
            while(resultSet.next())
            {
                Map<String, Object> row = new HashMap<String,Object>();
                for(int i=1;i<=column;i++)
                {
                    row.put(resultSetMetaData.getColumnLabel(i).toUpperCase(),resultSet.getObject(i));
                }
                results.add(row);
            }

        }catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally {
            closeDBConnection();
        }
        return results;
    }
    private void closeDBConnection(){
        if(Objects.nonNull(resultSet))
        {
            try{
                resultSet.close();
            }catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }
        if(Objects.nonNull(statement))
        {
            try{
                statement.close();
            }catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }
        if(Objects.nonNull(connection))
        {
            try{
                connection.close();
            }catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }
    }
}
