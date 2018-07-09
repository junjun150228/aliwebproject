package com.ali.mapper;

import com.ali.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPrestoMapper {

    @Insert("insert into city_sum(city_name,sum_num) values(#{cityName},#{sumNum})")
    int insertCitySum(CitySum citySum);

    @Delete("delelt from city_sum")
    int deleteCitySum();

    @Insert("insert into user_pay_count(date,count) values(#{date},#{count})")
    int insertUserPayCount(UserPayCount userPayCount);

    @Delete("delete from user_pay_count")
    int deleteUserPayCount();

    @Insert("insert into user_view_count(date,count) values(#{date},#{count})")
    int insertUserViewCount(UserViewCount userViewCount);

    @Delete("delete from user_view_count")
    int deleteUserViewCount();

    @Select("select city_name cityName,sum_num sumNum from city_sum")
    List<CitySum> selectCitySum();

    @Select("select date,count from  user_pay_count where date in(select date from user_view_count) order by date ")
    List<UserPayCount> selectUserPayCount();

    @Select("select date,count from user_view_count where date in(select date from user_pay_count) order by date ")
    List<UserViewCount> selectUserViewCount();


}
