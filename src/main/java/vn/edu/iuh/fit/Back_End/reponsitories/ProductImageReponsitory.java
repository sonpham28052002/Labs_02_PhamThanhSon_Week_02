package vn.edu.iuh.fit.Back_End.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.Back_End.ConectionDB.ConnectionDB;
import vn.edu.iuh.fit.Back_End.entities.ProductImage;

import java.util.List;

public class ProductImageReponsitory {
    private EntityManager entityManager;

    public ProductImageReponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }
    public ProductImage getOne(long id){
        return  entityManager.find(ProductImage.class,id);
    }

    public List<ProductImage> getProductImagesByProductID(long productID){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<ProductImage> productImageList = entityManager.createQuery("select pi from ProductImage pi",ProductImage.class).getResultList();
            transaction.commit();
            return productImageList;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public boolean insertProductImage(ProductImage productImage){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(productImage);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean deleteProductImage(ProductImage productImage){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(productImage);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public boolean updateProductImage(ProductImage productImage){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(productImage);
            transaction.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
