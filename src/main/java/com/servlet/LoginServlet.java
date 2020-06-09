package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "username", value = "Tush"),
                @WebInitParam(name = "password", value = "Tush")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get request parameters for userID and password
        String user = req.getParameter("username");
        String pwd = req.getParameter("password");
        //get servlet config init params
        String userID = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        if (userID.equals(user) && password.equals(pwd)) {
            req.setAttribute("username", user);
            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/LoginPage.jsp");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong_</font>");
            rd.include(req, resp);
        }
    }
}
