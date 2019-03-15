package com.vily.demo3.comtroller;


import com.vily.demo3.Demo3Application;
import com.vily.demo3.bean.ResultV;
import com.vily.demo3.config.api.ApiVersion;
import com.vily.demo3.util.StringUtils;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Access;
import javax.persistence.PostLoad;
import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *     http://192.168.93.113:8044/diary/user/
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class TestController {

    @ApiVersion(1)
    @GetMapping(value = "{version}/ble")
    public String ble(@RequestParam(value = "value") String value) {

        System.out.println("---------" + value);

        return "----";
    }


    @GetMapping(value = "/test")
    public ResultV testValue(@RequestParam(value = "data") String data, @RequestParam(value = "value") String value) {

        System.out.println("---------" + value);
        try {
            String decode = URLDecoder.decode(data, "utf-8");
            System.out.println("----------decoe:" + decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ResultV resultV=new ResultV();
        resultV.setCode(0);
        resultV.setMessage("hhhhhhhhhhh");

        return resultV;
    }

    @CrossOrigin
    @GetMapping(value = "/login")
    public ResultV login(@RequestParam(value = "phone") String phone, @RequestParam(value = "psw") String psw) {

        ResultV resultV=new ResultV();
        resultV.setCode(1000);
        resultV.setMessage("请求错误");
        resultV.setData(null);
        if(StringUtils.isEmpty(phone)){
            resultV.setCode(1002);
            resultV.setMessage("手机号不能为空");
            return resultV;
        }
        if(StringUtils.isEmpty(psw)){
            resultV.setCode(1003);
            resultV.setMessage("密码不能为空");
            return resultV;
        }
        System.out.println("----------phone:"+phone+"-----psw:"+psw);

        return resultV;
    }

    @PostMapping(value = "/upload")
    public ResultV upload(@RequestParam(value = "file",required = false) MultipartFile file,
                         @RequestParam(value = "access_token") String access_token,
                         @RequestParam(value = "client_id") String client_id) {


        System.out.println("-----------file:"+file.getContentType()+"---"+file.getOriginalFilename()+"---acc:"+access_token+"--cli:"+client_id);


        ResultV resultV=new ResultV();
        resultV.setCode(0);
        resultV.setMessage("hhhhhhhhhhh");

        return resultV;
    }

    @PutMapping(value = "/api/sn/devices/{id}")
    public ResultV resetCode(@PathVariable String id,@RequestBody String json) throws UnsupportedEncodingException {

        System.out.println("------------id:"+id+"-----json"+URLDecoder.decode(json,"utf-8"));

        ResultV resultV=new ResultV();
        resultV.setCode(0);
        resultV.setMessage("hhhhhhhhhhh");

        return resultV;
    }

}
