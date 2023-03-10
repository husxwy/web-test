package cn.hu.test.web.controller;

import cn.hu.test.web.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping({"/testAll"})
@Slf4j
public class TestAllController {
    @GetMapping({"/get"})
    public Result get(@RequestHeader Map<String, String> headers) {
        Date startTime = Calendar.getInstance().getTime();
        String start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(startTime.getTime());

        HashMap hashMap = new HashMap(10);
        hashMap.put("starTime", start);
        hashMap.put("headers", headers);
        log.info(hashMap.toString());

        return new Result(true, Integer.valueOf(20000), "查询成功", hashMap);
    }


    @GetMapping({"/delay/seconds/{seconds}"})
    public Result delaySeconds(@RequestHeader Map<String, String> headers, @PathVariable long seconds) {

        Date startTime = Calendar.getInstance().getTime();
        String start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(startTime.getTime());


        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date endTime = Calendar.getInstance().getTime();
        String end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(endTime);

        HashMap hashMap = new HashMap(10);
        hashMap.put("startTime", start);
        hashMap.put("endTime", end);
        hashMap.put("seconds", seconds);
        hashMap.put("headers", headers);

        log.info(hashMap.toString());

        return new Result(true, Integer.valueOf(20000), "查询成功", hashMap);
    }


    @GetMapping({"/delay/millisecond/{millisecond}"})
    public Result delayMillisecond(@RequestHeader Map<String, String> headers, @PathVariable long millisecond) {

        Date startTime = Calendar.getInstance().getTime();
        String start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(startTime.getTime());

        try {
            TimeUnit.MILLISECONDS.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date endTime = Calendar.getInstance().getTime();
        String end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA).format(endTime);

        HashMap hashMap = new HashMap(10);
        hashMap.put("startTime", start);
        hashMap.put("endTime", end);
        hashMap.put("millisecond", millisecond);
        hashMap.put("headers", headers);

        log.info(hashMap.toString());

        return new Result(true, Integer.valueOf(20000), "查询成功", hashMap);
    }

}
