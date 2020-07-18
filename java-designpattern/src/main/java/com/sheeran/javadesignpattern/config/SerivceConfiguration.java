package com.sheeran.javadesignpattern.config;

import com.sheeran.javadesignpattern.strategy.second.impl.ClearImpl;
import com.sheeran.javadesignpattern.strategy.second.impl.ToBeClearImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SerivceConfiguration
{
    @Autowired
    private ClearImpl clear;

    @Autowired
    private ToBeClearImpl toBeClear;

    @Bean("beansMap")
    public Map<String, Object> beansMap()
    {
        Map<String, Object> map = new HashMap<>(5);
        map.put("131404",clear);
        map.put("131406",toBeClear);
        return map;
    }
}
