package main.java.Application;


import java.sql.SQLException;

import main.java.Database.Database;

/**
 * Created by manuel on 10/16/2015.
 */
public class Main {

    private static Database database;

    public static void main(String args[]) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        //database information

        /*
        * URL: 217.199.187.197
        * DBNAME:cl56-socialline
        * USER:cl56-socialine
        * PASSWORD:eniLaicoS
        *
        * */

        database = new Database("217.199.187.197","cl56-socialine","cl56-socialine", "eniLaicoS");


    }
}
