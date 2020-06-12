package com.servlet;

import com.model.RegisterDao;
import com.model.UserInformation;

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
    PrintWriter out = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
        UserInformation user = new UserInformation(name, email, password);
        RegisterDao rDao = new RegisterDao();
        int result = rDao.insert(user);
        out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        if (result == 0) {
            out.println("alert('registration not submitted');");
        } else {
            out.println("alert('registration successful...!!!! ');");
            response.sendRedirect("LoginPage.jsp");
        }
        out.println("</script>");
        rd.include(request,response);
    }
}
