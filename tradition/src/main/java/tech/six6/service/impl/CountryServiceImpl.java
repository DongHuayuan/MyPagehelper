package tech.six6.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tech.six6.dao.CountryDao;
import tech.six6.entiy.Country;
import tech.six6.service.CountryService;
import tech.six6.util.PageUtil;
import tech.six6.util.SqlsessionFactoryUtil;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryServiceImpl implements CountryService {


    @Override
    public PageUtil getAllUsers(String num,int pageSize) throws Exception {

        SqlSession sqlSession=SqlsessionFactoryUtil.getSqlSessionFactory().openSession();

        CountryDao countryDao=sqlSession.getMapper(CountryDao.class);

        int currentPageNum=1;

        if(null!=num&&!num.trim().equals(""))
        {
            currentPageNum=Integer.parseInt(num);
        }

        int totalRecords=countryDao.totalRecords(); //总共记录数

        PageUtil pu=new PageUtil(currentPageNum,totalRecords,pageSize);

        List<Country> users= countryDao.selectAllPage(pu.getStartIndex(),pu.getPageSize());

        pu.setRecords(users);

        return pu;
    }
}
