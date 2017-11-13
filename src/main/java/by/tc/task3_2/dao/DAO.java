package by.tc.task3_2.dao;

import by.tc.task3_2.entity.User;

import java.util.List;

public interface DAO {
    List<User> getUserInformation(String name, String surname) throws DAOException;
}
