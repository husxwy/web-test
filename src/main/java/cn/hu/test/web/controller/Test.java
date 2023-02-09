package cn.hu.test.web.controller;

import cn.hu.test.web.common.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping({"/test"})
public class Test {
    @GetMapping({"/get"})
    public Result get() {

           return new Result(true, Integer.valueOf(20000), "查询成功",null );
    }


    @GetMapping({"/delay/seconds/{seconds}"})
    public Result delaySeconds(@PathVariable long seconds) {

        Date startTime = Calendar.getInstance().getTime();
        String star = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(startTime.getTime());



        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date endTime = Calendar.getInstance().getTime();
        String end =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.CHINA).format(endTime);

        HashMap hashMap = new HashMap();
        hashMap.put("startTime",star);
        hashMap.put("endTime",end);
        hashMap.put("seconds",seconds);

        return new Result(true, Integer.valueOf(20000), "查询成功",hashMap );
    }


    @GetMapping({"/delay/millisecond/{millisecond}"})
    public Result delayMillisecond(@PathVariable long millisecond) {

        Date startTime = Calendar.getInstance().getTime();
        String star = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(startTime.getTime());


        try {
                 TimeUnit.MILLISECONDS.sleep(millisecond);
               } catch (InterruptedException e) {
                  e.printStackTrace();
        }

        Date endTime = Calendar.getInstance().getTime();
        String end =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.CHINA).format(endTime);

        HashMap hashMap = new HashMap();
        hashMap.put("startTime",star);
        hashMap.put("endTime",end);
        hashMap.put("millisecond",millisecond);
        return new Result(true, Integer.valueOf(20000), "查询成功",hashMap );
    }

}
