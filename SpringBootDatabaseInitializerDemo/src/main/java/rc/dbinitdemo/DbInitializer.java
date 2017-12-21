package rc.dbinitdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {
    private BankAccountRepository bankAccountRepository;

    public DbInitializer(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.bankAccountRepository.deleteAll();

        BankAccount bankAccount1 = new BankAccount("John", 100);
        BankAccount bankAccount2 = new BankAccount("Anna", 300);

        this.bankAccountRepository.save(bankAccount1);
        this.bankAccountRepository.save(bankAccount2);

        System.out.println(" -- Database has been initialized");
    }
}
