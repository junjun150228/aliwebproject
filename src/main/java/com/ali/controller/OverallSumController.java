package com.ali.controller;

import com.ali.entity.MapInfo;
import com.ali.entity.ShopInfo;
import com.ali.service.IPrestoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 以城市为单位，统计每个城市总体消费金额 （饼状图）
 */
@Controller
@EnableAutoConfiguration
public class OverallSumController {

    static Logger logger = Logger.getLogger(OverallSumController.class);

    @Autowired
    private IPrestoService prestoService;

    @ResponseBody
    @RequestMapping("/getCitySum")
    public  List<MapInfo> getCitySum(){
        return prestoService.getCitySum();
    }

    @ResponseBody
    @RequestMapping("/getDateSum")
    public  HashMap<String,Object> getDateSum(){
        return prestoService.getDateSum();
    }

    @RequestMapping("/saveCitySumJob")
    public void oversum(){
        prestoService.saveCitySumJob();
    }

    @RequestMapping("/saveUserPayCountJob")
    public void saveUserPayCountJob(){
        prestoService.saveUserPayCountJob();
    }

    @RequestMapping("/saveUserViewCountJob")
    public void saveUserViewCountJob(){
        prestoService.saveUserViewCountJob();
    }

}
