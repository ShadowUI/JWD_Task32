package by.tc.task3_2.controller;

import by.tc.task3_2.entity.User;
import by.tc.task3_2.service.EntityService;
import by.tc.task3_2.service.ServiceException;
import by.tc.task3_2.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;

public class Controller extends HttpServlet {
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String ATTRIBUTE_NAME = "foundUsers";
    private static final String USER_INFO_PAGE = "WEB-INF/jsp/userInfoPage.jsp";
    private static final String USER_NOT_FOUND_PAGE = "WEB-INF/jsp/userNotFound.jsp";
    private static final String ERROR_PAGE_URL = "/WEB-INF/jsp/errorPage.jsp";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String CONTENT_TYPE = "text/html";

    private ServiceFactory factory = ServiceFactory.getInstance();
    private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType(CONTENT_TYPE);

        try {
            String name = request.getParameter(NAME);
            String surname = request.getParameter(SURNAME);

            EntityService service = factory.getEntityService();

            List<User> foundUsers = service.getUserInformation(name, surname);
            RequestDispatcher requestDispatcher;

            if (foundUsers != null){
                request.setAttribute(ATTRIBUTE_NAME, foundUsers);
                requestDispatcher = request.getRequestDispatcher(USER_INFO_PAGE);
            } else {
                requestDispatcher = request.getRequestDispatcher(USER_NOT_FOUND_PAGE);
            }
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            request.setAttribute(ERROR_ATTRIBUTE, e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_PAGE_URL);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
