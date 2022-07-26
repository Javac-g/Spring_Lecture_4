package com.company.Service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@org.springframework.stereotype.Service("Service_B")
@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Service_B implements Service {

    @Override
    public String getData(){
        return "Service b";

    }

}
