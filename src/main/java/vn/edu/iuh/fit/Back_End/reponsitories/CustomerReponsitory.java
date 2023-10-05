package vn.edu.iuh.fit.Back_End.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.Customer;

import java.util.List;

public class CustomerReponsitory{
    private EntityManager entityManager;

    public CustomerReponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public Customer getOne(long id){
        return entityManager.find(Customer.class,id);
    }

    public List<Customer> getAll(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<Customer> customerList=entityManager.createQuery("select cs from Customer cs",Customer.class).getResultList();
            transaction.commit();
            return  customerList;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }


    public boolean insertCustomer(Customer customer){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(customer);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean deleteCustomer(Customer customer){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(customer);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean updateCustomer(Customer customer){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(customer);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }



}
