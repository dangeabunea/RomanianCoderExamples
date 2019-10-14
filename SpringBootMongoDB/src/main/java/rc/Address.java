package rc;

public class Address {
    private String city;
    private String country;

    protected Address(String city,String country)
	{
	this.city=city;
	this.country=country;
	}
    protected Address(){}

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
