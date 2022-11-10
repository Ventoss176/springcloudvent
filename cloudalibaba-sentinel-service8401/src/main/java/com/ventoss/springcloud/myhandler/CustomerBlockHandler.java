package com.ventoss.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ventoss.springcloud.entities.CommonResult;

/**
 * @authoer:Ventoss
 * @createDate:2022/11/8
 * @description:
 */

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }
}
