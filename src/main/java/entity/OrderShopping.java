package entity;

import java.time.LocalDate;
import java.util.Objects;

public class OrderShopping {
    private Integer orderId;
    private LocalDate orderDate;
    private Double totalPrice;
    private Customer fkCustomerId;
    private Product fkProductId;

    public OrderShopping(Integer orderId,Double totalPrice,Customer fkCustomerId,Product fkProductId, LocalDate orderDate ) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.fkCustomerId = fkCustomerId;
        this.fkProductId = fkProductId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(Customer fkCustomerId) {
        this.fkCustomerId = fkCustomerId;
    }

    public Product getFkProductId() {
        return fkProductId;
    }

    public void setFkProductId(Product fkProductId) {
        this.fkProductId = fkProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderShopping that = (OrderShopping) o;
        return orderId.equals(that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "OrderShopping{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", fkCustomerId=" + fkCustomerId +
                ", fkProductId=" + fkProductId +
                '}';
    }
}
