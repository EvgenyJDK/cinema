package com.cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Админ on 21.04.2016.
 */
public class MySimpleServlet extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//            request.setAttribute("test1", "helloTest");

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Hello My!!!1!!!!SimpleServlet</h3>");
            out.println("</body>");
            out.println("</html>");

//        out.close(); // после закрытия стрима, дальнейшие вызовы сервлетов невозможны

//        request.getRequestDispatcher("/help").include(request, response);
//        request.getRequestDispatcher("/help").forward(request, response);

//            response.sendRedirect("/help");

        }




}
