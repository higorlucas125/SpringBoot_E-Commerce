package com.SpringBoot.E_Commerce.E_Commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("productList")
    private ProductCategory productCategory;

    @Column(name = "sku")
    @NotBlank
    private String SKU;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "cargo_price")
    private Float cargoPrice;

    @Column(name = "tax_percent")
    private Float taxPercent;

    @Column(name = "cart_desc")
    @NotBlank
    private String cartDesc;

    @Column(name = "long_desc")
    @Type(type = "text")
    @NotBlank
    private String longDesc;

    @Column(name = "thumb")
    @JsonIgnore
    private String thumb;

    @Column(name = "image")
    private String image;

    @Column(name = "date_created", insertable = false)
    @JsonIgnore
    private Date dateCreated;

    @Column(name = "last_updated", insertable = false)
    @Type(type = "timestamp")
    @JsonIgnore
    private Date lastUpdated;

    @Column(name = "stock")
    @NotNull
    private Float stock;

    @Column(name = "sell_count")
    @JsonIgnore
    private Integer sellCount;

    @Column(name = "live")
    @NotNull
    private Integer live;

    @Column(name = "unlimited")
    @NotNull
    private Integer unlimited;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(Float cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public Float getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Float taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getCartDesc() {
        return cartDesc;
    }

    public void setCartDesc(String cartDesc) {
        this.cartDesc = cartDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public Integer getLive() {
        return live;
    }

    public void setLive(Integer live) {
        this.live = live;
    }

    public Integer getUnlimited() {
        return unlimited;
    }

    public void setUnlimited(Integer unlimited) {
        this.unlimited = unlimited;
    }
}
