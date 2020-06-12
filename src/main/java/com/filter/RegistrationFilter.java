package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter("/RegistrationServlet")
public class RegistrationFilter implements Filter {
    private static final String NAME_PATTERN = "^[A-Z][a-z]{3,}$";
    private static final String EMAIL_PATTERN =  "^[0-9a-zA-Z]+([._+-][a-zA-Z]+)?@[0-9a-zA-Z]+[.][a-z]{2,4}([.][a-z]{2})?$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-zA-Z0-9@#!$%^&*_-]{8,})[a-zA-Z0-9]+[@#!$%^&*_-][a-zA-Z0-9]+$";
    private String name = null;
    private String email = null;
    private String password = null;
    private PrintWriter out = null;

    public void destroy () {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        name = request.getParameter("name");
        email = request.getParameter("email");
        password = request.getParameter("password");
        RequestDispatcher rd = request.getRequestDispatcher("/RegisterPage.jsp");
        out = response.getWriter();
        if (isAllFieldsEmpty() && isNameCorrect() && isEmailIdCorrect() && isPasswordMatch()) {
            chain.doFilter(request, response);
        } else {
            rd.include(request, response);
        }
    }

    private boolean isPasswordMatch () {
       if (password.matches(PASSWORD_PATTERN))
            return true;
        else {
           out.println("<script type=\"text/javascript\">");
           out.println("alert('invalid password" +
                        "note: password minimum 8 characters" +
                        "password have at least 1 uppercase" +
                        "password have at least 1 numeric" +
                        "password have exactly 1 special character');");
            out.println("</script>");
            return false;
        }
    }

    private boolean isEmailIdCorrect () {
        if (email.matches(EMAIL_PATTERN))
            return true;
        else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('invalid email-id');");
            out.println("</script>");
            return false;
        }
    }

    private boolean isNameCorrect () {
        if (name.matches(NAME_PATTERN))
            return true;
        else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('invalid name');");
            out.println("</script>");
            return false;
        }
    }

    private boolean isAllFieldsEmpty () {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('please fill all fields');");
            out.println("</script>");
            return false;
        } else
            return true;
    }

    public void init(FilterConfig config){
    }

}
