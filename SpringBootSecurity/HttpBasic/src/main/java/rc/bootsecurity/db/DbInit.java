package rc.bootsecurity.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import rc.bootsecurity.model.User;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Crete users
        User dan = new User("dan","dan123","USER","");
        User admin = new User("admin","admin123","ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager","manager123","MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
