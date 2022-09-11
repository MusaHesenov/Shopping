package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
    private Integer costId;
    private String username;
    private String email;
    private String costPassword;
    private String costName;
    private String costSurname;
    private LocalDate costBirthday;
    private Double costMoney;
    private String adress;
    private City fkCityId;

    public Customer() {

    }

    public Customer(Integer costId, String username, String email, String costPassword, String costName, String costSurname, LocalDate costBirthday, Double costMoney, String adress, City fkCityId) {
        this.costId = costId;
        this.username = username;
        this.email = email;
        this.costPassword = costPassword;
        this.costName = costName;
        this.costSurname = costSurname;
        this.costBirthday = costBirthday;
        this.costMoney = costMoney;
        this.adress = adress;
        this.fkCityId = fkCityId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCostPassword() {
        return costPassword;
    }

    public void setCostPassword(String costPassword) {
        this.costPassword = costPassword;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostSurname() {
        return costSurname;
    }

    public void setCostSurname(String costSurname) {
        this.costSurname = costSurname;
    }

    public LocalDate getCostBirthday() {
        return costBirthday;
    }

    public void setCostBirthday(LocalDate costBirthday) {
        this.costBirthday = costBirthday;
    }

    public Double getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Double costMoney) {
        this.costMoney = costMoney;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public City getFkCityId() {
        return fkCityId;
    }

    public void setFkCityId(City fkCityId) {
        this.fkCityId = fkCityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return costId.equals(customer.costId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "costId=" + costId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", costPassword='" + costPassword + '\'' +
                ", costName='" + costName + '\'' +
                ", costSurname='" + costSurname + '\'' +
                ", costBirthday='" + costBirthday + '\'' +
                ", costMoney=" + costMoney +
                ", adress='" + adress + '\'' +
                ", fkCityId=" + fkCityId +
                '}';
    }
}
