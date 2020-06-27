package com.SpringBoot.E_Commerce.E_Commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetailsList;

    @OneToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Size(min = 3, max = 52)
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @NotBlank
    private String shipName;

    @Column(name = "ship_address")
    @Size(min = 3, max = 240)
    @Pattern(regexp = "[0-9a-zA-Z #,-]+")
    @NotBlank
    private String shipAddress;

    @Column(name = "ship_address2")
    @Pattern(regexp = "[0-9a-zA-Z #,-]+")
    @Size(min = 3, max = 240)
    private String shipAddress2;

    @Column(name = "city")
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @NotBlank
    private String city;

    @Column(name = "state")
    @Size(min = 3, max = 40)
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    private String state;

    @Column(name = "zip")
    @Size(min = 5, max = 6)
    @Pattern(regexp = "^[0-9]*$")
    @NotBlank
    private String zip;

    @Column(name = "country")
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 40)
    @NotBlank
    private String country;

    @Column(name = "phone")
    @Pattern(regexp = "[0-9]+")
    @Size(min = 11, max = 12)
    @NotBlank
    private String phone;

    private Float totalPrice;

    private Float totalCargoPrice;

    @Size(min = 3, max = 52)
    @NotBlank
    private String email;

    @Type(type = "timestamp")
    private Date date;

    private Integer shipped;

    private String cargoFirm;

    private String trackingNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipAddress2() {
        return shipAddress2;
    }

    public void setShipAddress2(String shipAddress2) {
        this.shipAddress2 = shipAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getTotalCargoPrice() {
        return totalCargoPrice;
    }

    public void setTotalCargoPrice(Float totalCargoPrice) {
        this.totalCargoPrice = totalCargoPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getShipped() {
        return shipped;
    }

    public void setShipped(Integer shipped) {
        this.shipped = shipped;
    }

    public String getCargoFirm() {
        return cargoFirm;
    }

    public void setCargoFirm(String cargoFirm) {
        this.cargoFirm = cargoFirm;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
