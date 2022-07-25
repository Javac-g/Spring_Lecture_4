package com.company.Service;

import org.springframework.beans.factory.annotation.Value;

public class Service_B implements Service {

    @Override
    public String getData(){
        return "Service b";

    }

}
