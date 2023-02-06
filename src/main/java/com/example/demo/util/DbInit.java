package com.example.demo.util;

import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DbInit {

    private final RoleService roleService;
    private final UserService usersService;

    @Autowired
    public DbInit(RoleService roleService, UserService usersService) {
        this.roleService = roleService;
        this.usersService = usersService;
    }

    @PostConstruct
    public void initialization() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);
        User admin = new User("admin", "admin", "admin@mail.ru", 12, "$2a$12$D3G3sxs3gkLOavFqfeJMaukOHG9ulQ170kJ8jtxlLvpvxhEpP2Ca6");
        admin.setRoles(Set.of(roleAdmin));
        User user = new User("user", "user", "user@mail.ru", 20, "$2a$12$mgtIgUkY6M1oQ8S4Ycnwaew/yYiyHX4HpV8x2aA3TjpC83MtS4.u2");
        user.setRoles(Set.of(roleUser));
        usersService.saveUser(admin);
        usersService.saveUser(user);

    }
}
