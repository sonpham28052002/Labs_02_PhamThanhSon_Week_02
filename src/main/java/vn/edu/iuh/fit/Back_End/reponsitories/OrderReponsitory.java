package vn.edu.iuh.fit.Back_End.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.Order;

import java.util.List;

public class OrderReponsitory {
    private final EntityManager entityManager;

    public OrderReponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public Order getOne(long id) {
        return entityManager.find(Order.class, id);
    }

    public List<Order> getOrderByCustID(long custID) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<Order> orderList = entityManager.createQuery("select od from Order od where  od.customer.id ='" + custID + "'", Order.class).getResultList();
            transaction.commit();
            return orderList;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public List<Order> getOrderByEmplID(long emplID) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<Order> orderList = entityManager.createQuery("select od from Order od where  od.employee.id ='" + emplID + "'", Order.class).getResultList();
            transaction.commit();
            return orderList;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public boolean insertOrder(Order order){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(order);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean deleteOrder(Order order){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(order);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean updateOrder(Order order){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(order);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public List<Order> getAll(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<Order> list =entityManager.createQuery("select od from Order od",Order.class).getResultList();
            transaction.commit();
            return list;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

}
