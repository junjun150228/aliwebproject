package com.ali.service;

import com.ali.dao.IStatisticalDao;
import com.ali.entity.*;
import com.ali.mapper.IPrestoMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrestoService implements IPrestoService{
    @Autowired
    private IPrestoMapper prestoMapper;

    @Autowired
    private IStatisticalDao statisticalDao;


    @Override
    public List<MapInfo> getCitySum() {
        List<MapInfo> reqlist = new ArrayList();
        List<CitySum> list = prestoMapper.selectCitySum();
        int i=0;
        for(CitySum cs:list){
            MapInfo info = new MapInfo();
            info.setName(cs.getCityName());
            info.setValue(cs.getSumNum());
            reqlist.add(info);
        }
        return reqlist;
    }

    @Override
    public HashMap<String,Object> getDateSum() {
        HashMap<String,Object> date = new HashMap();
        List<UserPayCount> a2list = prestoMapper.selectUserPayCount();
        List<UserViewCount> a1list = prestoMapper.selectUserViewCount();
        List<String> datalist = new ArrayList();
        List<Integer> list1= new ArrayList();
        List<Integer> list2= new ArrayList();
        for(UserViewCount a1info:a1list){
            datalist.add(a1info.getDate());
            list1.add(a1info.getCount());
        }
        for(UserPayCount a2info:a2list){
          list2.add(a2info.getCount());
        }

        date.put("date1",datalist);
        date.put("date2",list1);
        date.put("date3",list2);
        return date;
    }

    public int saveCitySumJob() {
        int end = 0;
        HashMap<String,Integer> map = statisticalDao.selectCitySum();
        prestoMapper.deleteCitySum();
        for(String key : map.keySet()){
            //保存到库中
            CitySum c = new CitySum();
            c.setCityName(key);
            c.setSumNum(map.get(key));
            prestoMapper.insertCitySum(c);
        }
        return end;
    }


    public int saveUserPayCountJob() {
        int end = 0;
        HashMap<String,Integer> map = statisticalDao.selectUserPayCount();
        prestoMapper.deleteUserPayCount();
        for(String key : map.keySet()){
            //保存到库中
            UserPayCount c = new UserPayCount();
            c.setDate(key);
            c.setCount(map.get(key));
            prestoMapper.insertUserPayCount(c);
        }
        return end;
    }

    @Override
    public int saveUserViewCountJob() {
        int end = 0;
        HashMap<String,Integer> map = statisticalDao.selectUserViewCount();
        prestoMapper.deleteUserViewCount();
        for(String key : map.keySet()){
            //保存到库中
            UserViewCount c = new UserViewCount();
            c.setDate(key);
            c.setCount(map.get(key));
            prestoMapper.insertUserViewCount(c);
        }
        return end;
    }


}
