package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "product_price")
public class ProductPrice implements Serializable {
    @Id
    @Column(name = "price_date_time", columnDefinition = "datetime(6)")
    private LocalDateTime priceDateTime;

    @Column(columnDefinition = "nvarchar(255)")
    private String note;

    private double price;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",columnDefinition = "bigint(20)")
    private Product product;

    public ProductPrice(LocalDateTime priceDateTime, String note, double price, Product product) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
        this.product = product;
    }

    public ProductPrice() {
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", product=" + product +
                '}';
    }
}
