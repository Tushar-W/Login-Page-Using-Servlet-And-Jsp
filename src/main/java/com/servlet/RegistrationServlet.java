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
    public final String EMAIL_PATTERN = "^[0-9a-zA-Z]{1,}([._+-]{1}[a-zA-Z]+)?[@][0-9a-zA-Z]{1,}[.][a-z]{2,4}([.]{1}[a-z]{2})?$";
    public final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-zA-Z0-9@#!$%^&*_-]{8,})[a-zA-Z0-9]{1,}[@#!$%^&*_-]{1}[a-zA-Z0-9]{1,}$";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (name.matches(NAME_PATTERN)) {
            if (email.matches(EMAIL_PATTERN)){
                if (password.matches(PASSWORD_PATTERN)){
                    new UserInformation(name, email, password);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<font color=green>Registration Successfully</font>");
                    rd.include(request, response);
                }else{
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<font color=red>password is wrong_</font>");
                    rd.include(request, response);
                }
            }else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>email is wrong_</font>");
                rd.include(request, response);
            }
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red> name is wrong_</font>");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

