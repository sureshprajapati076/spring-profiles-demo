package com.example.demo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Configuration
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public String defaultOne(){
        System.out.println("DEFAULT LOADING....");
        return "Default";
    }
    @Bean
    @Profile("dev")
    public String devOne(){
        System.out.println("DEV ENV CHOOSING ...");
        return "DEV";
    }

    @Bean
    @Profile("test")
    public String testOne(){
        System.out.println("TESTING ENV...");
        return "TEST";
    }

    @Bean
    @Profile("prod")
    public String prodOne(){
        System.out.println("PROD ENV ...");
        return "PRODUCTION";
    }


    @Bean
    public List<Integer> getList(){
        System.out.println("LIST ...");
        return Arrays.asList(1,2,3,4,5);
    }

    @Bean
    public List<Integer> getMyList(){
        System.out.println("LIST ENV ...");
        return Arrays.asList(111,222,333,444,555);
    }

    @Bean
    @Primary
    public String myString(){
        return "MY STRING";
    }

    @Bean
    @Profile("prod")

    public String getMyString(){
        return "GET MY STRING";
    }







}
