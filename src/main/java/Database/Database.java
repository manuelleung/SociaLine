package main.java.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String url, dbName, user, pass;

    //set up and connect to database here
    public Database(String url, String dbName, String user, String pass) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        //instantitate the driver
       Class.forName("com.mysql.jdbc.Driver").newInstance();
        //set the default variables
        this.url = url;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass;

        //setting up the connection

        connect = DriverManager
                .getConnection("jdbc:mysql://" + url + "/"+ dbName +"?"
                        + "user=" + user +  "&password=" + pass);

        if(connect != null)
            System.out.println("Connected to database " + url + " !");


    }

    //execute a sql statement
    public void ExecuteStatement(String ExecuteString) throws SQLException{
        //connection dropped, we gotta reconnect
        if(connect == null)
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + url + "/"+ dbName +"?"
                            + "user=" + user +  "&password=" + pass);
        //statement is null
        if(preparedStatement == null)
            preparedStatement = connect.prepareStatement(ExecuteString);

        resultSet = preparedStatement.executeQuery();


    }

    //get result set after executing a certain statment e.g seach
    public ResultSet getResultSet(){
        return resultSet;
    }

    // You need to close the database to stop waste.
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}