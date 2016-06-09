package com.cinema.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Админ on 02.05.2016.
 */
public class LogoutServlet extends HttpServlet {                 // TODO: 02.05.2016

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
            if(cookie.getName().equals("JSESSIONID")){
                System.out.println("JSESSIONID=" + cookie.getValue());
            }
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
    }

    HttpSession session = req.getSession();
    System.out.println("User=" + session.getAttribute("user"));
    if(session != null){
        session.invalidate();                                       //обнуление, деактивация сессии//
    }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/login.jsp");
        PrintWriter out= resp.getWriter();
        out.println("<font color=red>Logout successfully.</font>");
        rd.include(req, resp);
}

}
