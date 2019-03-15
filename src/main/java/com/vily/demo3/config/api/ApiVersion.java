package com.vily.demo3.config.api;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 *  * description : 接口版本控制 一个系统上线后会不断迭代更新，需求也会不断变化，有可能接口的参数也会发生变化，
 * 如果在原有的参数上直接修改，可能会影响线上系统的正常运行，这时我们就需要设置不同的版本，这样即使参数发生变化，
 * 由于老版本没有变化，因此不会影响上线系统的运行。
 *
 * 一般我们可以在地址上带上版本号，也可以在参数上带上版本号，还可以再 header 里带上版本号，
 * 这里我们在地址上带上版本号，大致的地址如：http://api.example.com/v1/test，其中，v1 即代表的是版本号
 *
 *  * Author : Vily
 *  * Date : 2019-03-15
 *  
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

    int value();
}
