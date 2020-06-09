package com.tdj.SpringBootDemo1.models.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.tdj.SpringBootDemo1.models.common.vo.SearchVo;
import com.tdj.SpringBootDemo1.models.test.entity.City;

@Mapper
public interface CityDao {

	List <City> getCitiesByCountryId(int countryId);
	
	@Select("select * from m_city where country_id = #{countryId}")
	List <City> getCitiesByCountryId2(int countryId);
	
	@Select("select * from m_city where city_name=#{cityName} and local_city_name=#{localCityName}")
	City getCityByName(String cityName, String localCityName);
	
	@Select("<script>" + 
			"select * from m_city "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (city_name like '%${keyWord}%' or local_city_name like '%${keyWord}%') "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ " order by ${orderBy} ${sort}"
			+ "</when>"
			+ "<otherwise>"
			+ " order by city_id desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List <City> getCitiesBySearchVo (SearchVo searchVo);
	
	@Insert("insert into m_city (city_name, local_city_name, country_id, date_created) " 
			+ "values(#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
	@Options(useGeneratedKeys = true, keyColumn = "city_id", keyProperty = "cityId")	//通过注解来使用插入数据的主键并映射到实体类中的相应属性
	void insertCity(City city);
	
	
}
