package com.company.Service;

import org.springframework.beans.factory.annotation.Value;

public class Service_B {
    @Value("${prop.B}")
    private String one;

    public String getOne(){
        return one;

    }

}
