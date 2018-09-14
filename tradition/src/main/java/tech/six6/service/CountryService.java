package tech.six6.service;

import tech.six6.entiy.Country;
import tech.six6.util.PageUtil;

import java.util.List;

public interface CountryService {

    public PageUtil getAllUsers(String num,int pageSize) throws  Exception;

}
