package vn.edu.iuh.fit.Back_End.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.Employee;
import vn.edu.iuh.fit.Back_End.enums.EmployeeStatus;

import java.util.List;

public class EmployeeReponsitory{

    private EntityManager entityManager;

    public EmployeeReponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }
    public Employee getOne(long id){
        return entityManager.find(Employee.class,id);
    }
    public List<Employee> getAllEmplyees() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<Employee> employeeList = entityManager.createQuery("select empl from Employee empl", Employee.class).getResultList();
            transaction.commit();
            return employeeList;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public boolean insertEmployee(Employee employee){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(employee);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean deleteEmployee(Employee employee){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            employee.setStatus(EmployeeStatus.TEMINATED);
            entityManager.merge(employee);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean updateEmployee(Employee customer){
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
