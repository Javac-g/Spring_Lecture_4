package com.company.Controller;

import com.company.Service.Service;
import com.company.Service.Service_A;
import com.company.Service.Service_B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/Main")
public class Controller {
    private final static Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    @Qualifier("Service_B")

    private Service services;




    @RequestMapping(value = "/S", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String service(){
        log.info("https://192.168.0.104:8080/Main/S");
        log.info("Service: " + services);

        return "\n" + services.getData();
    }
}
