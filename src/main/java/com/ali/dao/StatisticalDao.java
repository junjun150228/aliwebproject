package com.ali.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.HashMap;

@Repository
public class StatisticalDao  extends PrestoDao implements IStatisticalDao{

    @Override
    public HashMap<String, Integer> selectCitySum() {
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        try {
            ResultSet rs =  exec("select s.city_name,sum(s.per_pay) from user_pay u left join shop_info s on u.shop_id = s.shop_id group by s.city_name");
            while (rs.next()) {
                res.put(rs.getString(1).replaceAll("'",""),rs.getInt(2));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            close();
        }
        return res;
    }



    @Override
    public HashMap<String, Integer> selectUserPayCount() {
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        try {
            ResultSet rs =  exec(" select DATE_FORMAT(time_stamp,'%Y-%m-%d'),count(0) from user_pay group by DATE_FORMAT(time_stamp,'%Y-%m-%d')");
            while (rs.next()) {
                res.put(rs.getString(1),rs.getInt(2));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            close();
        }
        return res;
    }


    @Override
    public HashMap<String, Integer> selectUserViewCount() {
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        try {
            ResultSet rs =  exec(" select DATE_FORMAT(time_stamp,'%Y-%m-%d'),count(0) from user_view group by DATE_FORMAT(time_stamp,'%Y-%m-%d')");
            while (rs.next()) {
                res.put(rs.getString(1),rs.getInt(2));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            close();
        }
        return res;
    }





}
