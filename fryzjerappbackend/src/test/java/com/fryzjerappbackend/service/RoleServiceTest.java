package com.fryzjerappbackend.service;

import com.fryzjerappbackend.model.Role;
import com.fryzjerappbackend.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Test
    public void shouldGetAllRoles() {
        //given
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role());
        roleList.add(new Role());

        //when
        when(roleRepository.findAll()).thenReturn(roleList);

        //then
        List<Role> result = roleService.getAllRoles();
        verify(roleRepository, times(1)).findAll();
        assertEquals(result.size(), 2);
        assertEquals(result.size(), roleList.size());
    }

    @Test
    public void shouldCreateRole() {
        //given
        Role role = new Role();

        //when

        //then
        roleService.createRole(role);
        verify(roleRepository, times(1)).save(role);
    }
}
