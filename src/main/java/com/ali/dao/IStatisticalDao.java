package com.ali.dao;

import java.util.HashMap;

public interface IStatisticalDao {

    HashMap<String,Integer> selectCitySum();

    HashMap<String, Integer> selectUserPayCount();

    HashMap<String, Integer> selectUserViewCount();
}
