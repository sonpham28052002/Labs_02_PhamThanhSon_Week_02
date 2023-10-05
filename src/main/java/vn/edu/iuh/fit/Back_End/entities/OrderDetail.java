package vn.edu.iuh.fit.Back_End.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_detail")

public class OrderDetail implements Serializable {
    @Id
    @JoinColumn(name = "order_id")
    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "order_id")
    @JsonIgnoreProperties(value = {"orderDate","customer","employee","orderDetailList"})
    private Order order;

    @Id
    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "productId")
    @JsonIgnoreProperties(value = {"productImageList","orderDetailList","productPriceList","description","manufacturer","name","status","unit"})
    private Product product;


    @Column(columnDefinition = "nvarchar(255)")
    private String note;

    @Column
    private double price;

    @Column
    private double quantity;

    public OrderDetail() {
    }

    public OrderDetail(Product product, Order order, String note, double price, double quantity) {
        this.product = product;
        this.order = order;
        this.note = note;
        this.price = price;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "product=" + product +
                ", order=" + order +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }


}
