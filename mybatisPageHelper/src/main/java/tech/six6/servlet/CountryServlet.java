package tech.six6.servlet;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tech.six6.entiy.Country;
import tech.six6.entiy.User;
import tech.six6.service.CountryService;
import tech.six6.service.impl.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CountryServlet",urlPatterns = "/CountryServlet")
public class CountryServlet extends HttpServlet {

    private CountryService countryService = new CountryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user="+user);
        if (user == null){
            System.out.println("user为空");
            response.sendRedirect("/login.jsp");
        }else if (!user.getUsername().equals("admin")){
            System.out.println("user的用户名不是admin");
            response.sendRedirect("/login.jsp");
        }else{
            System.out.println("进行跳转");
            String action = request.getParameter("action");
            System.out.println("action="+action);
            if (action.equals("all")){
                System.out.println("进入action。。。");
                selectAllCountry(request,response);
            }
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //获取所有的用户信息
    private void selectAllCountry(HttpServletRequest request,  HttpServletResponse response)throws ServletException, IOException  {
        int pageSizeInt;
        String num = request.getParameter("num");
        String pageSize = request.getParameter("pageSize");
        System.out.println("num="+num);
        System.out.println("pageSize="+pageSize);
        if (null == num){
            num="1";
        }
        if (null == pageSize || "" == pageSize){
            pageSizeInt =10;
        }else{
            pageSizeInt = Integer.parseInt(pageSize);
        }

        System.out.println(Integer.parseInt(num));
        System.out.println(pageSizeInt);
        Page<?> page=PageHelper.startPage(Integer.parseInt(num),pageSizeInt);


        List<Country> countries=countryService.getAllUsersPageHelper();


        PageInfo<?> pageHelper=page.toPageInfo();

        System.out.println("pageHelper"+pageHelper);

        request.setAttribute("countries",countries);
        request.setAttribute("pagehelper",pageHelper);
        request.setAttribute("pageSize",pageSize);

        request.getRequestDispatcher("/CountryPage.jsp").forward(request,response);

//        PageUtil pageUtil = null;
//        try {
//            pageUtil = countryService.getAllUsers(num,pageSizeInt);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("pageUtil="+pageUtil);
//        request.setAttribute("page",pageUtil);
//        request.setAttribute("pageSize",pageSize);
//
//        request.getRequestDispatcher("country.jsp").forward(request,response);
    }
}
