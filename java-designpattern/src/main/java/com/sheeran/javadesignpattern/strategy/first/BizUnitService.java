package com.sheeran.javadesignpattern.strategy.first;

import org.springframework.stereotype.Service;

@Service
public class BizUnitService
{
    public String bizOne(String order) {
        return order + "各种花式操作1";
    }
    public String bizTwo(String order) {
        return order + "各种花式操作2";
    }
    public String bizThree(String order) {
        return order + "各种花式操作3";
    }
}
