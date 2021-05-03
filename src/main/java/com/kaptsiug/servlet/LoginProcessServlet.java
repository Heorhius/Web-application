package com.kaptsiug.servlet;

import com.kaptsiug.db.UserProvider;
import com.kaptsiug.model.User;
import com.kaptsiug.util.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginProcessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserProvider provider = UserProvider.getProvider();
        User user = provider.getUsersByLoginPassword(login, password);

        if (user == null) {
            req.setAttribute("failedLogin", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            if (CookiesUtil.getUserCookies(req) == 0) {
                CookiesUtil.setUserCookies(resp);
            }
            resp.sendRedirect("profile.jsp");
        }
    }
}
