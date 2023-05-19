package repository;

import empty.Customer;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@Singleton
public class CustomerRepository {

    private EntityManagerFactory entityManagerFactory;

    public CustomerRepository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("managerFactory");
    }

    public List<Customer> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Customer> customers = entityManager.createQuery("select new Customer (a.id, a.zip, a.name_customer, a.address, a.email, a.state) from Customer a", Customer.class).getResultList();
        entityManager.close();
        return customers;
    }

    public void add(Customer customer){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Customer customer = entityManager.find(Customer.class, id);
        if (customer != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public Customer findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.close();
        return customer;
    }

    public void updateCustomer(Customer customer){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
