package cn.hu.test.web.controller;

import cn.hu.test.web.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping({"/testLog"})
@Slf4j
public class TestLogController {
    @GetMapping({"/get"})
    public Result get(@RequestHeader Map<String, String> headers) {

        log.info("header:{}",headers);

        return new Result(true, Integer.valueOf(20000), "查询成功", headers);
    }


    @GetMapping({"/delay/seconds/{seconds}"})
    public Result delaySeconds(@RequestHeader Map<String, String> headers, @PathVariable long seconds) {

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("header:{}, seconds:{}",headers,seconds);
        return new Result(true, Integer.valueOf(20000), "查询成功", headers);
    }


    @GetMapping({"/delay/millisecond/{millisecond}"})
    public Result delayMillisecond(@RequestHeader Map<String, String> headers, @PathVariable long millisecond) {

        try {
            TimeUnit.MILLISECONDS.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("header:{}, millisecond:{}",headers,millisecond);
        return new Result(true, Integer.valueOf(20000), "查询成功", headers);
    }

}
