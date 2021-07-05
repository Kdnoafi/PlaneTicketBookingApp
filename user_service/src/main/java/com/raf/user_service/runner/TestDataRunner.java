package com.raf.user_service.runner;

import com.raf.user_service.domain.Rank;
import com.raf.user_service.domain.Role;
import com.raf.user_service.domain.User;
import com.raf.user_service.domain.UserStatus;
import com.raf.user_service.repository.RoleRepository;
import com.raf.user_service.repository.UserRepository;
import com.raf.user_service.repository.UserStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserStatusRepository userStatusRepository;

    public TestDataRunner(RoleRepository roleRepository, UserRepository userRepository, UserStatusRepository userStatusRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userStatusRepository = userStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role("ROLE_ADMIN", "admin");
        Role roleUser = new Role("ROLE_USER", "user");
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(roleAdmin);
        userRepository.save(admin);

        userStatusRepository.save(new UserStatus(0, 999, 0, Rank.BRONZA));
        userStatusRepository.save(new UserStatus(1000, 9999, 10, Rank.SREBRO));
        userStatusRepository.save(new UserStatus(10000, Integer.MAX_VALUE, 20, Rank.ZLATO));
    }

}
