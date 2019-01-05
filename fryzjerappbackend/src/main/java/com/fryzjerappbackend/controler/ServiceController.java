package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Service;
import com.fryzjerappbackend.service.ServiceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    private static final Logger LOG = LogManager.getLogger(com.fryzjerappbackend.controler.ServiceController.class);

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody Service service) {
        LOG.info("Service {} has been created.");
        serviceService.createService(service);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Service> getServices() {
        return serviceService.getAllServices();
    }
}

