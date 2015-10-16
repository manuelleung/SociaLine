package main.java.Application;


import java.sql.SQLException;

import main.java.Database.Database;

/**
 * Created by manuel on 10/16/2015.
 */
public class Main {

    private static Database database;

    public static void main(String args[]) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        //database connection
        database = new Database(Config.DBURL,Config.DBNAME,Config.DBUSER, Config.DBPASS);
        
    }
}
