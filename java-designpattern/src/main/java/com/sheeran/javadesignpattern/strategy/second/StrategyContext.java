package com.sheeran.javadesignpattern.strategy.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("StrategyContext")
public class StrategyContext
{
    @Autowired
    @Qualifier("beansMap")
    private Map<String, Object> beans;

    public String handleData(String rule,String data)
    {
        Map<String, Object> map = (Map<String, Object>) beans.get("beansMap");
        Strategy strategy = (Strategy) map.get(rule);
        return strategy.handle(data);
    }
}
