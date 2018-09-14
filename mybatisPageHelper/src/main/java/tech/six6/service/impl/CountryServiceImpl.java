package tech.six6.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tech.six6.dao.CountryDao;
import tech.six6.entiy.Country;
import tech.six6.service.CountryService;
import tech.six6.util.SqlsessionFactoryUtil;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryServiceImpl implements CountryService {


    @Override
    public List<Country> getAllUsersPageHelper(){

        SqlSession sqlSession=SqlsessionFactoryUtil.getSqlSessionFactory().openSession();

        CountryDao countryDao=sqlSession.getMapper(CountryDao.class);

        List<Country> countries=countryDao.selectAll();

        return countries;
    }
}
