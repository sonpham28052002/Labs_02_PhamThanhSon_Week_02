package vn.edu.iuh.fit.Back_End.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.ProductPrice;

import java.util.List;

public class ProductPriceReponsitory{

    private EntityManager entityManager;

    public ProductPriceReponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public ProductPrice getPriceAtTheEnd(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            ProductPrice productPrice=entityManager.createQuery("select pp from product_price pp order by pp.priceDateTime desc ",ProductPrice.class).getResultList().get(0);
            transaction.commit();
            return productPrice;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
    public List<ProductPrice> getAll(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<ProductPrice> productPrices =entityManager.createQuery("select pp from product_price pp",ProductPrice.class).getResultList();
            transaction.commit();
            return productPrices;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public boolean deleteProductPrice(ProductPrice productPrice){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(productPrice);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean updateProductPrice(ProductPrice productPrice){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(productPrice);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean insertProductPrice(ProductPrice productPrice){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(productPrice);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

}
