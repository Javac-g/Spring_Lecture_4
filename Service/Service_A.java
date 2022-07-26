package com.company.Service;


import org.springframework.context.annotation.Primary;

@org.springframework.stereotype.Service
//@Primary
public class Service_A implements Service {

    @Override
    public String getData(){
        return "Service A";
    }
}
