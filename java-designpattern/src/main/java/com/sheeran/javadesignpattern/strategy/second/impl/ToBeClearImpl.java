package com.sheeran.javadesignpattern.strategy.second.impl;

import com.sheeran.javadesignpattern.strategy.second.Strategy;
import org.springframework.stereotype.Service;

@Service
public class ToBeClearImpl implements Strategy
{
    @Override
    public String handle(String order)
    {
        return "ToBeClearImpl";
    }
}
