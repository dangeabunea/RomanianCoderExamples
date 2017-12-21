package rc.dbinitdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String owner;
    private int amount;

    // used for serialization / deserialization
    protected BankAccount(){}

    public BankAccount(String owner, int amount){

        this.owner = owner;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getAmount() {
        return amount;
    }
}
