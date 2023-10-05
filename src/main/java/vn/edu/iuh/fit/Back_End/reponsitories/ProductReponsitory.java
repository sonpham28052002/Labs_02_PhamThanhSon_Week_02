package vn.edu.iuh.fit.Back_End.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.Product;
import vn.edu.iuh.fit.Back_End.enums.ProductStatus;

import java.util.List;

public class ProductReponsitory {
    private EntityManager entityManager;

    public ProductReponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }
    public Product getOne(long id){
        return  entityManager.find(Product.class,id);
    }
    public List<Product> getAll(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<Product> customerList=entityManager.createQuery("select pr from Product pr",Product.class).getResultList();
            transaction.commit();
            return  customerList;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public boolean deleteProduct(Product product){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            product.setStatus(ProductStatus.TEMINATED);
            entityManager.merge(product);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean insertProduct(Product product){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(product);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean updateProduct(Product product){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(product);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
