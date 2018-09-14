package tech.six6.servlet;

import tech.six6.entiy.User;
import tech.six6.service.UserService;
import tech.six6.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/LoginServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username);
        System.out.println("password="+password);
        if ("" == username || null == username || "" == password || null == password){
            response.sendRedirect("/login.jsp");
        }else{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user = userService.CheckUsernameAndPassword(user);
            System.out.println("user="+user);
            if (user == null){
                response.sendRedirect("/login.jsp");
            }else if (user.getId() > 0){
                System.out.println("登陆成功");
                request.setAttribute("username",username);
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/CountryServlet?action=all&pageSize=10").forward(request,response);
            }else {
                response.sendRedirect("/login.jsp");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
