package com.amos.minimalism;

import com.amos.minimalism.log.SystemControllerLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * * Licensed to CMDT,Inc. under the terms of the CMDT
 * Software License version 1.0.
 * <p>
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * ----------------------------------------------------------------------------
 * Date           Author               Version        Comments
 * 2018/7/7      Li Yiliu                1.0          Initial Version
 */


@SpringBootApplication
@RestController
public class BetterManApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetterManApplication.class, args);
    }

    @RequestMapping("/test")
    @SystemControllerLog(description = "测试controller")
    public void test(@RequestParam String name){
        System.out.println("进入测试controller:" + name);
    }

}
