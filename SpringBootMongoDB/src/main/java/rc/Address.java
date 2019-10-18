package rc;

import lombok.Data;

//@Data
public class Address {
    private String city;
    private String country;

    protected Address(){}

    public Address(String city, String country) {
        this.city =city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
