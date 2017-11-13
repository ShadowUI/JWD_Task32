package by.tc.task3_2.service;

import by.tc.task3_2.entity.User;

import java.util.List;

public interface EntityService {
    List<User> getUserInformation(String name, String surname) throws ServiceException;
}
