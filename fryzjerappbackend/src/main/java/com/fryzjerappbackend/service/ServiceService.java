package com.fryzjerappbackend.service;

import com.fryzjerappbackend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    @Autowired
    ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void createService(com.fryzjerappbackend.model.Service service) {
        serviceRepository.save(service);
    }

    public List<com.fryzjerappbackend.model.Service> getAllServices() {
        return serviceRepository.findAll();
    }
}
