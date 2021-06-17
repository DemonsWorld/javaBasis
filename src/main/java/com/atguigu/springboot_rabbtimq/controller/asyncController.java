package com.atguigu.springboot_rabbtimq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kakrolot
 * @date 2020/5/8 16:19
 */
@RestController
public class asyncController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "success";
    }
}
