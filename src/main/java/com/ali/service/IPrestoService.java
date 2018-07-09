package com.ali.service;

import com.ali.entity.MapInfo;
import com.ali.entity.ShopInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPrestoService {

    List<MapInfo> getCitySum();

    HashMap<String,Object> getDateSum();

    int saveCitySumJob();

    int saveUserPayCountJob();

    int saveUserViewCountJob();
}
