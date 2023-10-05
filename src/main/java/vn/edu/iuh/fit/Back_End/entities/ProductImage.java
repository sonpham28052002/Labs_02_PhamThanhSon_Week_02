package vn.edu.iuh.fit.Back_End.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity()
@Table(name = "product_image")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "image_id")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ProductImage implements Serializable {
    @Id
    @Column(name = "image_id",columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("image_id")
    private long image_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonProperty("product")
    private Product product;
    @Column(columnDefinition = "nvarchar(250)")
    @JsonProperty("alternative")
    private String alternative;
    @Column(columnDefinition = "nvarchar(250)")
    @JsonProperty("path")
    private String path;



    public ProductImage(String alternative, String path, Product product) {
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
