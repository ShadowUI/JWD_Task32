package by.tc.task3_2.service;

import by.tc.task3_2.service.impl.EntityServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final EntityService entityService = new EntityServiceImpl();

    private ServiceFactory() {}

    public EntityService getEntityService() {
        return entityService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}
