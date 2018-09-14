package tech.six6.dao;

import tech.six6.entiy.User;

public interface UserDao {

    int add(User user);

    User CheckUsernameAndPassword(User user);

}
