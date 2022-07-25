package com.company.Configuration;

import com.company.Controller.Controller;
import com.company.Service.Service_A;
import com.company.Service.Service_B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class SpringConfigurationFactory {
    @Bean("A")
    @Scope(value = "prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Service_A serviceA(){

        return new Service_A();

    }
    @Bean("B")
    @Scope(value = "prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Service_B serviceB(){

        return new Service_B();

    }

    @Bean("Controller")
    public Controller controller(){
        Controller controller = new Controller();
        controller.setServiceA(serviceA());
        controller.setServiceB(serviceB());
        return controller;
    }
}
