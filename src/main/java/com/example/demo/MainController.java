package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private List<Integer> getList;


    @Autowired
    private List<Integer> getMyList;

    @Autowired

    private String getMyString;

    @Autowired
    private String myString;


    @Value("${server.port:8080}")
    public Integer port;
    @Value("${env.name:Default}")
    public String envName;
    @Value("${spring.application.name:Default}")
    public String appName;

    @GetMapping("/")
    public Map<String,String> home(){
        Map<String,String> map=new HashMap<>();
        map.put("APPLICATION NAME",appName);
        map.put("ENVIRONMENT",envName);
        map.put("PORT",port.toString());

        System.out.println(getList);
        System.out.println(getMyList);
        System.out.println(myString);
        System.out.println(getMyString);
        return map;
    }
}
