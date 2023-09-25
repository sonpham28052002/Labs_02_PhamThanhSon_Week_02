package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "product_id", columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(columnDefinition = "nvarchar(250)")
    private String description;
    @Column(columnDefinition = "nvarchar(100)")
    private String manufacturer;
    @Column(columnDefinition = "nvarchar(100)")
    private String name;
    @Column(columnDefinition = "int(11)")
    private ProductStatus status;
    @Column(columnDefinition = "nvarchar(25)")
    private String unit;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductImage> productImageList = new ArrayList<>();
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList = new ArrayList<>();
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductPrice> productPriceList=new ArrayList<>();
    public Product(long productId, String description, String manufacturer, String name, ProductStatus status, String unit) {
        this.productId = productId;
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.status = status;
        this.unit = unit;
    }

    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public List<ProductPrice> getProductPriceList() {
        return productPriceList;
    }

    public void setProductPriceList(List<ProductPrice> productPriceList) {
        this.productPriceList = productPriceList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", unit='" + unit + '\'' +
                '}';
    }
}
