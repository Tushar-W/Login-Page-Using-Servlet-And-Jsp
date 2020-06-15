package com.servlet;

import com.dao.RegisterDao;
import com.model.UserInformation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"}
)
public class LoginServlet extends HttpServlet {
    PrintWriter out=null;
    RegisterDao dao = new RegisterDao();
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        /*
          get request parameters for username and password
         */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        /*
          get registered user information
         */
        UserInformation user = dao.checkUser(username, password);
        if (user.getName()==null && user.getPassword()==null) {
            out = resp.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('username or password is wrong');");
            out.println("</script>");
            req.getRequestDispatcher("LoginPage.jsp").include(req, resp);
        }else {
            HttpSession session= req.getSession();
            session.setAttribute("username",user.getName());
            session.setAttribute("email",user.getEmail());
            session.setAttribute("date",user.getDate());
            out = resp.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('login successful');");
            out.println("</script>");
            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
        }
    }
}
