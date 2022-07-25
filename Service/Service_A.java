package com.company.Service;

import org.springframework.beans.factory.annotation.Value;

public class Service_A {
    @Value("${prop.A}")
    private String one;

    public String getOne(){
        return one;
    }
}
