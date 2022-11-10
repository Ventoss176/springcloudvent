package com.ventoss.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ventoss.springcloud.entities.CommonResult;
import com.ventoss.springcloud.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @authoer:Ventoss
 * @createDate:2022/11/7
 * @description:
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        int a = 10 / 0;
        log.info("testD 异常比例");
        return "------testB";
    }

    @GetMapping("/testC")
    public ModelAndView testC(HttpServletRequest request, HttpServletResponse response) {

        return new ModelAndView("redirect:/testA");

    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }

    @GetMapping("/testGlobal")
    @SentinelResource(value = "testGlobal", blockHandlerClass = {CustomerBlockHandler.class}, blockHandler = "handleException")
    public CommonResult testGlobal() {
        return new CommonResult(200,"success");

    }




}
