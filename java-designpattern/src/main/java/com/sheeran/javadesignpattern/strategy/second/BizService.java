package com.sheeran.javadesignpattern.strategy.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BizService
{
    @Autowired
    private StrategyContext strategyContext;

    public String getTranFlow(String rule,String data)
    {
        return strategyContext.handleData(rule,data);
    }
}
