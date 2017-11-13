package by.tc.task3_2.service.impl;

import by.tc.task3_2.dao.DAO;
import by.tc.task3_2.dao.DAOException;
import by.tc.task3_2.dao.DAOFactory;
import by.tc.task3_2.entity.User;
import by.tc.task3_2.service.EntityService;
import by.tc.task3_2.service.ServiceException;

import java.util.List;

public class EntityServiceImpl implements EntityService {

    private static final String VALIDATION_EXCEPTION_MESSAGE = "Invalid parameters";

    public List<User> getUserInformation(String name, String surname) throws ServiceException {

        boolean invalidInput = name == null || surname == null || name.isEmpty() || surname.isEmpty();
        if (invalidInput){
            throw new ServiceException(VALIDATION_EXCEPTION_MESSAGE);
        }

        DAOFactory factory = DAOFactory.getInstance();
        DAO entityDAO = factory.getEntityDAO();

        List<User> foundUsers;
        try {
            foundUsers = entityDAO.getUserInformation(name, surname);
            return foundUsers;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
