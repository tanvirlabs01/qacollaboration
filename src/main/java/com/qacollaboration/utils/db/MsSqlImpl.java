package com.qacollaboration.utils.db;

import java.sql.*;
import java.util.*;

public class MsSqlImpl implements DataBaseUtil{
    private static MsSqlImpl instance;
    private static String msSqlDriver = "";
    private static String msSqlHostName = "";
    private static String msSqlUserName = "";
    private static String msSqlPassword = "";
    private static String msSqlDataBase = "";
    private static String msSqlDataBasePort = "";
    private static Statement statement;
    private Connection connection;
    private ResultSet resultSet;

    //Example
    public static void main(String[] args) throws SQLException {
        MsSqlImpl msSqlUtil = new MsSqlImpl();
        List<Map<String,?>> result= msSqlUtil.select("select * from asm.Charter_FuelTypes where id = 2;");
        System.out.println(result.get(0).get("FUELTYPE"));
        System.out.println(result.get(0).get("ID"));
    }
    protected MsSqlImpl() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://" + msSqlHostName + ":" + msSqlDataBasePort + ";" + "database =" + msSqlDataBase
                + ";" + "user=" + msSqlUserName + ";" + "password=" + msSqlPassword + ";";
        try{
            Class.forName(msSqlDriver);
            this.connection = DriverManager.getConnection(connectionUrl);
        }catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }
    private Connection getConnection()
    {
        return this.connection;
    }
    protected static MsSqlImpl getInstance() throws SQLException {
        if(Objects.nonNull(instance))
        {
            instance = new MsSqlImpl();
        }else if(instance.getConnection().isClosed())
        {
            instance = new MsSqlImpl();
        }
        return instance;
    }

    @Override
    public List<Map<String,?>> select(String query) {
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
