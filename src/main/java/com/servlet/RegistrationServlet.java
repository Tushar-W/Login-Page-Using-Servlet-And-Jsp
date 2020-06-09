package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    public final String NAME_PATTERN = "^[A-Z]{1}[a-z]{3,}$";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (name.matches(NAME_PATTERN)) {
            new UserInformation(name, email, password);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=green>Registration Successfully</font>");
            rd.include(request, response);
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either name or password or email is wrong_</font>");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

