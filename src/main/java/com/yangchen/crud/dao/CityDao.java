package com.yangchen.crud.dao;

import com.yangchen.crud.domain.City;
import org.apache.ibatis.annotations.Param;

public interface CityDao {

    City findByName(@Param("cityName") String cityName);

    void insertCity(@Param("id") Long id, @Param("provinceId") Long provinceId, @Param("cityName") String cityName, @Param("description") String description);

    void deleteById(@Param("id") Long id);

    void updateById(@Param("id") Long id, @Param("provinceId") Long provinceId, @Param("cityName") String cityName, @Param("description") String description);
}
