package com.yangchen.crud.service;

import com.yangchen.crud.dao.CityDao;
import com.yangchen.crud.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    public void insertCity(City city){
        cityDao.insertCity(city.getId(), city.getProvinceId(), city.getCityName(), city.getDescription());
    }

    public void deleteCityById(Long id){
        cityDao.deleteById(id);
    }

    public void updateCityById(City city){
        cityDao.updateById(city.getId(), city.getProvinceId(), city.getCityName(), city.getDescription());
    }
}
