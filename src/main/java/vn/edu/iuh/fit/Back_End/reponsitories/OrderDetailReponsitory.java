package vn.edu.iuh.fit.Back_End.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.OrderDetail;

import java.util.List;

public class OrderDetailReponsitory {
    private EntityManager entityManager;

    public OrderDetailReponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public OrderDetail getOne(long order_id , long product_id){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            OrderDetail orderDetail=entityManager
                    .createQuery("select odd from OrderDetail odd where odd.order.id= :orderID and odd.product.id= :productID",OrderDetail.class)
                    .setParameter("orderID",order_id)
                    .setParameter("productID",product_id)
                    .getSingleResult();
            transaction.commit();
            return orderDetail;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public List<OrderDetail> getListOrderDetailByOrderID(long orderID){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<OrderDetail> orderDetailList=entityManager.
                    createQuery("select odd from OrderDetail odd where odd.order.id= :orderID",OrderDetail.class)
                    .setParameter("orderID",orderID)
                    .getResultList();
            transaction.commit();
            return orderDetailList;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public List<OrderDetail> getListOrderDetailByProductID(long productID){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<OrderDetail> orderDetailList=entityManager.
                    createQuery("select odd from OrderDetail odd where odd.product.id= :productID",OrderDetail.class)
                    .setParameter("productID",productID)
                    .getResultList();
            transaction.commit();
            return orderDetailList;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public boolean insertOrderDetail(OrderDetail orderDetail){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(orderDetail);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    
    public boolean deleteOrderDetail(OrderDetail orderDetail){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(orderDetail);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
