package tech.six6.dao;

import org.apache.ibatis.annotations.Param;
import tech.six6.entiy.Country;

import java.util.List;

public interface CountryDao {

    int add(Country country);

    int delete(int id);

    int update(Country country);

    Country selectById(int id);

    List<Country> selectAll();

    List<Country> selectAllPage(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    Integer totalRecords();
}
