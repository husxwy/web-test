package cn.hu.test.web.controller;

import cn.hu.test.web.common.entity.Result;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping({"/testNull"})
public class TestNullController {
    @GetMapping({"/get"})
    public void get() {
    }


    @GetMapping({"/delay/seconds/{seconds}"})
    public void delaySeconds(@PathVariable long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @GetMapping({"/delay/millisecond/{millisecond}"})
    public void delayMillisecond(@PathVariable long millisecond) {
        try {
                 TimeUnit.MILLISECONDS.sleep(millisecond);
               } catch (InterruptedException e) {
                  e.printStackTrace();
        }
    }

}
