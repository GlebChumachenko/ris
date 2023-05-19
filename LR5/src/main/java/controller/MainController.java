package controller;

import empty.Customer;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import repository.CustomerRepository;

import java.util.List;


@ManagedBean
@SessionScoped
public class MainController {

    @Inject
    private CustomerRepository customerRepository;

    private final int[] states = {1, 60, 3, 4, 5, 81, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    private Customer customer = new Customer();

    private String TempId;

    public String getTempId() {
        return TempId;
    }

    public void setTempId(String tempId) {
        TempId = tempId;
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public void addCustomer() {
        customerRepository.add(customer);
        removeCustomerAndBack();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(Long.parseLong(id));
    }

    public void findCustomerById(String id) {
        this.customer = new Customer();
        this.customer = customerRepository.findById(Long.parseLong(id));
    }

    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    public void removeCustomerAndBack() {
        this.customer = new Customer();
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler handler = context.getApplication().getNavigationHandler();
        handler.handleNavigation(context, null, "index.xhtml");
    }

    public int[] getStates() {
        return states;
    }
}
