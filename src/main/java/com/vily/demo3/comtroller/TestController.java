package com.vily.demo3.comtroller;


import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/user")
public class TestController {

    @GetMapping(value = "/test")
    public String testValue(@RequestParam(value = "data") String data,@RequestParam(value = "value") String value){

        System.out.println("---------"+value);

        try {
            String decode = URLDecoder.decode(data, "utf-8");


            System.out.println("----------decoe:"+decode);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }

        return value;
    }
}
