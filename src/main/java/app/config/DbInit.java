package app.config;

import app.model.Role;
import app.model.User;
import app.service.RoleService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInit {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
        System.out.println("DbInit done!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

//    @Bean
//    @PostConstruct
//    public void initializer() {
//        User admin = new User("admin", 33, "admin@email.com", "admin", null);
//        User user = new User("user", 22, "user@maol.com", "user", null);
//
//        userService.save(admin);
//        userService.save(user);
//    }

    @PostConstruct
    public void postConstruct() {

        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        System.out.println("1");

        Set<Role> roleSetAdmin = new HashSet<>();
        roleSetAdmin.add(roleService.getRoleByName("ROLE_ADMIN"));
//        roleSetAdmin.add(roleService.getRoleByName("ROLE_USER"));

        System.out.println("2");

        Set<Role> roleSetUser = new HashSet<>();
        roleSetUser.add(roleService.getRoleByName("ROLE_USER"));

        System.out.println("3");

        User admin = new User("admin", 33, "admin@email.com", "admin", roleSetAdmin);
        User user = new User("user", 22, "user@mail.com", "user", roleSetUser);

        System.out.println("4");

        admin.setRoles(Set.of(roleService.getRoleByName("ROLE_ADMIN")));
        user.setRoles(Set.of(roleService.getRoleByName("ROLE_USER")));

        System.out.println("5");

        userService.save(admin);
        userService.save(user);

        System.out.println("6");
    }
}
