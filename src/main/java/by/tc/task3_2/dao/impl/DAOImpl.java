package by.tc.task3_2.dao.impl;

import by.tc.task3_2.dao.DAO;
import by.tc.task3_2.dao.DAOException;
import by.tc.task3_2.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class DAOImpl implements DAO {

    private static final String SQL_EXCEPTION_MESSAGE = "SQL ERROR";

    public List<User> getUserInformation(String name, String surname) throws DAOException{
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;

        String query = "SELECT * FROM users WHERE users.name = '" + name
                + "' AND users.surname = '" + surname + "'";

        try {
            connection = ConnectorToDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if (!resultSet.isBeforeFirst()) {
                return null;
            }

            List<User> userList = createUsers(resultSet);

            return userList;
        } catch (SQLException e) {
            throw new DAOException(SQL_EXCEPTION_MESSAGE);
        } finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                ConnectorToDB.closeConnection(connection);
            }
        }
    }

    private List<User> createUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();

        while (resultSet.next()) {
            int column = 1;
            User user = new User();
            user.setName(resultSet.getString(column++));
            user.setSurname(resultSet.getString(column++));
            user.setPhoneNumber(resultSet.getString(column++));
            user.setEmail(resultSet.getString(column));
            users.add(user);
        }

        return users;
    }
}
