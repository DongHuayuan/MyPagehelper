package tech.six6.service.impl;

import org.apache.ibatis.session.SqlSession;
import tech.six6.dao.CountryDao;
import tech.six6.dao.UserDao;
import tech.six6.entiy.User;
import tech.six6.service.UserService;
import tech.six6.util.SqlsessionFactoryUtil;

public class UserServiceImpl implements UserService {


    @Override
    public int add(User user) {
        SqlSession sqlSession=SqlsessionFactoryUtil.getSqlSessionFactory().openSession();

        UserDao userDao=sqlSession.getMapper(UserDao.class);
        if (user == null ){
            return 0;
        }
        return userDao.add(user);
    }

    @Override
    public User CheckUsernameAndPassword(User user) {

        SqlSession sqlSession=SqlsessionFactoryUtil.getSqlSessionFactory().openSession();

        UserDao userDao=sqlSession.getMapper(UserDao.class);

        if (user == null ){
            return null;
        }

        return userDao.CheckUsernameAndPassword(user);
    }
}
