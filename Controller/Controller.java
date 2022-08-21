package com.company.Controller;

import com.company.Model.DataEntity;
import com.company.Reposytory.DataRepository;
import com.company.Service.EntityService;
import com.company.Service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RequestMapping("/Main")
public class Controller {
    private final static Logger log = LoggerFactory.getLogger(Controller.class);
    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    @Qualifier("EntityService")
    private EntityService entityService;

    @Autowired              // Direct mapping by value
    @Qualifier("Service_B")
    private Service A;

    @Autowired        //Mapped by @Primary
    private Service B;



    @RequestMapping(value = "/S", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String service(){
        log.info("https://192.168.0.104:8080/Main/S");
        log.info("A: " + A);
        log.info("B: " + B);

        return "\n" + A.getData() + "\n" + B.getData();
    }
    @PostConstruct
    public void init(){
        log.info("PostConstruct initialised");
    }
    @PreDestroy
    public void destroy(){
        log.info("PreDestroy call");

    }
    @RequestMapping(value = "/shutdown", method = RequestMethod.GET)
    private void shutdown(){
        ((ConfigurableApplicationContext)applicationContext).close();
    }

    @GetMapping(value = "/getData",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<DataEntity> getData(){
        return entityService.getData();
    }
    @PostMapping(value = "/sendData",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void setData(@RequestBody personDTO person){
         entityService.setData(person);
    }

}
