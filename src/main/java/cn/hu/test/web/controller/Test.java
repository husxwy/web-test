package cn.hu.test.web.controller;

import cn.hu.test.web.common.entity.Result;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping({"/test"})
public class Test {
    @GetMapping({"/get"})
    public Result get(@RequestHeader Map<String, String> headers) {
        HashMap hashMap = new HashMap();
        hashMap.put("headers",headers);
           return new Result(true, Integer.valueOf(20000), "查询成功",hashMap );
    }


    @GetMapping({"/delay/seconds/{seconds}"})
    public Result delaySeconds(@RequestHeader Map<String, String> headers,@PathVariable long seconds) {

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
        hashMap.put("headers",headers);
        return new Result(true, Integer.valueOf(20000), "查询成功",hashMap );
    }


    @GetMapping({"/delay/millisecond/{millisecond}"})
    public Result delayMillisecond(@RequestHeader Map<String, String> headers,@PathVariable long millisecond) {

        Date startTime = Calendar.getInstance().getTime();
        String star = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(startTime.getTime());

        headers.forEach((key, value) -> {

        });

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
        hashMap.put("headers",headers);
//        HashMap headersHashMap = new HashMap();
//        headers.forEach((key, value) -> {
//            headersHashMap
//        });

        return new Result(true, Integer.valueOf(20000), "查询成功",hashMap );
    }

}
