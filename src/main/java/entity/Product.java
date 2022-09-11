package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private Integer productId;
    private String productName;
    private Integer productCount;
    private LocalDate expiredDate;
    private Double price;
    private TypeShop fkProductTypeId;

    public Product() {

    }

    public Product(Integer productId, String productName, Integer productCount, LocalDate expiredDate, Double price, TypeShop fkProductTypeId) {
        this.productId = productId;
        this.productName = productName;
        this.productCount = productCount;
        this.expiredDate = expiredDate;
        this.price = price;
        this.fkProductTypeId = fkProductTypeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeShop getFkProductTypeId() {
        return fkProductTypeId;
    }

    public void setFkProductTypeId(TypeShop fkProductTypeId) {
        this.fkProductTypeId = fkProductTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return
                 productId +" "+ productName + ' ' + productCount + ' ' + expiredDate + ' ' + price +" " +fkProductTypeId ;
    }
}
