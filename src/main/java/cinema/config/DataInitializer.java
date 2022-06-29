package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {
    @Value("${db.url}")
    String url;
    @Value("${db.user}")
    String user;
    @Value("${db.password}")
    String password;
    @Value("${db.migrations.location}")
    String location;
//    private final RoleService roleService;
//    private final UserService userService;
//
//    public DataInitializer(RoleService roleService, UserService userService) {
//        this.roleService = roleService;
//        this.userService = userService;
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Flyway flyway = Flyway.configure().dataSource(url, user, password )
                .locations(location)
                .load();
        flyway.migrate();
        System.out.println("here");
    }

//    @PostConstruct
//    public void inject() {
//        Role adminRole = new Role();
//        adminRole.setRoleName(Role.RoleName.ADMIN);
////        roleService.add(adminRole);
////        Role userRole = new Role();
////        userRole.setRoleName(Role.RoleName.USER);
////        roleService.add(userRole);
//        User user = new User();
//        user.setEmail("admin@i.ua");
//        user.setPassword("admin123");
//        user.setRoles(Set.of(adminRole));
//        userService.add(user);
//    }
}
