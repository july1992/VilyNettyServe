package com.vily.demo3;

import com.vily.demo3.push.PushExample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo3Application implements CommandLineRunner {

    public static void main(String[] args) {

        System.out.println("----------1");
        SpringApplication.run(Demo3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------测试极光推送");
        PushExample pushExample=new PushExample();
        pushExample.testSendPush();
    }
}

