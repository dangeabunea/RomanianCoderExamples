package rc.dbinitdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;

    public BankAccountController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/all")
    public Iterable<BankAccount> all(){
        return this.bankAccountRepository.findAll();
    }
}
