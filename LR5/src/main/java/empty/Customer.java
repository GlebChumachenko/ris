package empty;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int zip;
    private String name_customer;
    private String address;
    private String email;
    private int state;

    public Customer(int zip, String name_customer, String address, String email, int state) {
        this.zip = zip;
        this.name_customer = name_customer;
        this.address = address;
        this.email = email;
        this.state = state;
    }

    public Customer(Long id, int zip, String name_customer, String address, String email, int state){
        this.id = id;
        this.zip = zip;
        this.name_customer = name_customer;
        this.address = address;
        this.email = email;
        this.state = state;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name) {
        this.name_customer = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
