package com.vily.demo3.comtroller;


import com.vily.demo3.bean.ResultV;
import com.vily.demo3.config.api.ApiVersion;
import com.vily.demo3.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *     http://192.168.93.113:8044/diary/user/
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class TestController2 {

    @ApiVersion(2)
    @GetMapping(value = "{version}/blwe")
    public String ble(@RequestParam(value = "value") String value) {

        System.out.println("---------" + value);

        return "ssssss";
    }

}
