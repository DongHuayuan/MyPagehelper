package tech.six6.service;

import tech.six6.entiy.User;

public interface UserService {

    int add(User user);

    User CheckUsernameAndPassword(User user);

}
