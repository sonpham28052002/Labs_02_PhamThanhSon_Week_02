package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity()
@Table(name = "product_image")
public class ProductImage implements Serializable {
    @Id
    @Column(name = "image_id",columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long image_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(columnDefinition = "nvarchar(250)")
    private String alternative;
    @Column(columnDefinition = "nvarchar(250)")
    private String path;



    public ProductImage(long image_id, String alternative, String path, Product product) {
        this.image_id = image_id;
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public ProductImage() {
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "image_id=" + this.image_id +
                ", alternative='" + this.alternative + '\'' +
                ", path='" + this.path + '\'' +
                '}';
    }
}
