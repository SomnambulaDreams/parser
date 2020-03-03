package dao;

import utils.MySqlHandler;
import utils.exceptions.DbClientException;

import java.sql.*;
import java.util.List;

public class VehicleBrandDAOImpl implements VehicleBrandDAO {


    @Override
    public void addVehicleBrand(List<String> brandNames) {
        Connection connection = setConnection();
        PreparedStatement statement = setStatement(connection, "insert into VehicleBrands (Name) VALUES (?)");
        try {
            for (String brandName : brandNames) {
                statement.setString(1, brandName);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException sqlex) {
            try {
                throw new DbClientException("Application obtain blocker during creation statement", sqlex);
            } catch (DbClientException dcex) {
                dcex.printStackTrace();
            }
        } finally {
            close(statement, connection);
        }
    }


    private Connection setConnection() {
        Connection connection = null;
        try {
            connection = MySqlHandler.getConnection();
        } catch (DbClientException dcex) {
            dcex.printStackTrace();
        }
        return connection;
    }


    private Statement setStatement(Connection connection) {
        Statement statement = null ;
        try {
            statement = connection.createStatement();
        } catch (SQLException sqlex) {
            try {
                throw new DbClientException("Application obtain blocker during creation statement", sqlex);
            } catch (DbClientException dcex) {
                dcex.printStackTrace();
            }
        }
        return statement;
    }


    private PreparedStatement setStatement(Connection connection, String query) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
        } catch (SQLException sqlex) {
            try {
                throw new DbClientException("Application obtain blocker during creation statement", sqlex);
            } catch (DbClientException dcex) {
                dcex.printStackTrace();
            }
        }
        return statement;
    }


    private ResultSet execute(Statement statement, String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlex) {
            try {
                throw new DbClientException("Application obtain blocker during creation statement", sqlex);
            } catch (DbClientException dcex) {
                dcex.printStackTrace();
            }
        }
        return resultSet;
    }


    private void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
        } catch (SQLException sqlex) {
            try {
                throw new DbClientException("Application obtain blocker during closing result set", sqlex);
            } catch (DbClientException dcex) {
                dcex.printStackTrace();
            }
        }
        close(statement, connection);
    }


    private void close(Statement statement, Connection connection) {
        try {
            statement.close();
        } catch (SQLException sqlex) {
            try {
                throw new DbClientException("Application obtain blocker during closing statement", sqlex);
            } catch (DbClientException dcex) {
                dcex.printStackTrace();
            }
        }
        try {
            connection.close();
        } catch (SQLException sqlex) {
            try {
                throw new DbClientException("Application obtain blocker during closing connection", sqlex);
            } catch (DbClientException dcex) {
                dcex.printStackTrace();
            }
        }
    }
}