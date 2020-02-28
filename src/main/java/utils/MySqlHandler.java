package utils;

import constants.MySQL;
import utils.exceptions.DbClientException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlHandler {

    private static Connection connection;


    public static Connection getConnection() throws DbClientException {
        try {
            if(connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://" +
                        MySQL.HOST.value + ":" +
                        MySQL.PORT.value + "/" +
                        MySQL.DB.value,
                        MySQL.USER.value,
                        MySQL.PASSWORD.value);
            }
            return connection;
        } catch(SQLException sqlex) {
            throw new DbClientException("Application did not create connection to " + MySQL.HOST.value + " using db " + MySQL.DB.value, sqlex);
        }
    }
}