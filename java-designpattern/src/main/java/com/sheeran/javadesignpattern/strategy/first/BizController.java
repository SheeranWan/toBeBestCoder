package com.sheeran.javadesignpattern.strategy.first;

import com.sheeran.javadesignpattern.strategy.second.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BizController
{
    @Autowired
    private BizBeforeService bizBeforeService;

    @Autowired
    private BizAfterService bizAfterService;

    @Autowired
    private BizService bizService;

    @PostMapping("/v1/biz/testBefore")
    public String test1(String order)
    {
        return bizBeforeService.getCheckResult(order);
    }

    @PostMapping("/v1/biz/testAfter")
    public String test2(String order)
    {
        return bizAfterService.getCheckResultComX(order,3);
    }

    @PostMapping("/v1/biz/testHandle")
    public String test3(String rule,String data)
    {
        return bizService.getTranFlow(rule,data);
    }
}
