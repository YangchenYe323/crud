package com.yangchen.crud.controller;

import com.yangchen.crud.domain.City;
import com.yangchen.crud.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.stream.StreamResult;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    @ResponseBody
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "api/insert", method = RequestMethod.GET)
    @ResponseBody
    public String insertCity(@RequestParam(value = "id", required = true)long id,
                             @RequestParam(value = "provinceId", required = true)long provinceId,
                             @RequestParam(value = "cityName", required = true)String cityName,
                             @RequestParam(value = "description", required = false)String description){

        City city = new City();
        city.setId(id);
        city.setCityName(cityName);
        city.setProvinceId(provinceId);
        city.setDescription(description);

        try{
            cityService.insertCity(city);
        } catch(Exception e){
            e.printStackTrace();
            return "Failed";
        }

        return "Succeeded";

    }

    @RequestMapping(value="api/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestParam(value = "id", required = true) Long id){
        try{
            cityService.deleteCityById(id);
        } catch(Exception e){
            e.printStackTrace();
            return "Failed";
        }
        return "Succeeded";
    }

    @RequestMapping(value = "api/update", method = RequestMethod.GET)
    @ResponseBody
    public String updateCity(@RequestParam(value = "id", required = true)long id,
                             @RequestParam(value = "provinceId", required = true)long provinceId,
                             @RequestParam(value = "cityName", required = true)String cityName,
                             @RequestParam(value = "description", required = false)String description){

        City city = new City();
        city.setId(id);
        city.setCityName(cityName);
        city.setProvinceId(provinceId);
        city.setDescription(description);

        try{
            cityService.updateCityById(city);
        } catch(Exception e){
            e.printStackTrace();
            return "Failed";
        }

        return "Succeeded";

    }

}
