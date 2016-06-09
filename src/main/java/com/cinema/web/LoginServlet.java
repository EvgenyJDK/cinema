package com.cinema.web;

import com.cinema.dto.UserDTO;
import com.cinema.model.Role;
import com.cinema.model.User;
import com.cinema.service.api.UserService;
import com.cinema.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Админ on 26.04.2016.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<h1>Hello LoginAction with doGet method</h1>");
//        out.println("</body>");
//        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String login = req.getParameter("login");
    String password = req.getParameter("password");

    UserService userService = UserServiceImpl.getInstance();
    UserDTO userDTO = userService.findUserByLoginPassword(login, password);

    if(userDTO != null){
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String userRole = userDTO.getRole().name();

        HttpSession session = req.getSession(true);
        session.setAttribute("userRole", userRole);
        session.setMaxInactiveInterval(15*60);                              // 15 минут                                                                      //
        req.setAttribute("firstName", firstName);
        req.setAttribute("lastName", lastName);
        if(userRole == Role.ADMIN.name()){                                                                            // ПРОВЕРКА КТО ЛОГИНИТСЯ
            System.out.println("redirect to administration");
        resp.sendRedirect("/administration");
        }else {
        req.getRequestDispatcher("/resources/jsp/loginSuccess.jsp").forward(req, resp);                               // УСПЕШНОЕ ЛОГИРОВАНИЕ
        }
        }else {
        // ОШИБКА В ЛОГИНЕ ИЛИ ПАРОЛЕ. ПОПРОБУЙТЕ ЕЩЕ РАЗ ИЛИ ЗАРЕГЕСТРИРУЙТЕСЬ
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/login.jsp");
        PrintWriter out= resp.getWriter();
        out.println("<font color=red>Wrong login or password.</font>");
        rd.include(req, resp);
        }



//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        System.out.println("Login Servlet");
//        /*вызов сервиса и проверка наличия юзера в БД*/
//
//        User user = new User(1, "Kovalenko", "admin", "admin", "man", 2000, 01, 01, "admin@mail.ru", Role.ADMIN);
//
//        // достаем пользователя с БД
//
//        if (user.getLogin().equals(username) && user.getPassword().equals(password)) {
//            HttpSession session = req.getSession();
//            session.setAttribute("user", user);
//            req.getRequestDispatcher("/resources/jsp/home.jsp").forward(req, resp);
//        } else {
////              req.getRequestDispatcher("/resources/jsp/registration.jsp").forward(req, resp);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/resources/jsp/registration.jsp");
//            PrintWriter out= resp.getWriter();
//            out.println("<font color=red>User with such name is absent. Please register.</font>");
////            out.println("<a href=\"<c:url value=\"/index\"></c:url>REGISTER</a>");
//            rd.include(req, resp);
//        }

    }
}

