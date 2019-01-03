package com.fryzjerappbackend.controler;

import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class RoleController {
    private static final Logger LOG = LogManager.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @PostMapping("/login/create/role")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@RequestBody Role role) {
        roleService.createRole(role);
    }

    @GetMapping("login/get/role")
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }
}
