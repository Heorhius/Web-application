package com.kaptsiug.servlet;

import com.kaptsiug.exception.IllegalIDException;
import com.kaptsiug.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/data")
public class UserServlet extends HttpServlet {
    private final static Logger LOG = Logger.getLogger(UserServlet.class.getName());
    private static final String LOG_USER_DELETED = "User with id = %s";
    private static final String LOG_USER_ADDED = "New user added";
    private final UserService userService;

    public UserServlet() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(userService.getAllUsersForResponse());
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        userService.addUser(body);
        LOG.info(LOG_USER_ADDED);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            userService.deleteUser(id);
            LOG.info(String.format(LOG_USER_DELETED, id));
        } catch (IllegalIDException | SQLException e) {
            LOG.warning(e.getMessage());
            resp.setStatus(400);
        }
    }
}
