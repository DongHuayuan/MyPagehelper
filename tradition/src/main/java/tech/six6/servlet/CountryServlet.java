package tech.six6.servlet;

import tech.six6.service.CountryService;
import tech.six6.service.impl.CountryServiceImpl;
import tech.six6.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CountryServlet",urlPatterns = "/CountryServlet")
public class CountryServlet extends HttpServlet {

    private CountryService countryService = new CountryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action="+action);
        if (action.equals("all")){
            System.out.println("进入action。。。");
            selectAllCountry(request,response);
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

        PageUtil pageUtil = null;
        try {
            pageUtil = countryService.getAllUsers(num,pageSizeInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("pageUtil="+pageUtil);
        request.setAttribute("page",pageUtil);
        request.setAttribute("pageSize",pageSize);

        request.getRequestDispatcher("country.jsp").forward(request,response);
    }
}
