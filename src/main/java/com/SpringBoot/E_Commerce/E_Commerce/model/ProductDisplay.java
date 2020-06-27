package com.SpringBoot.E_Commerce.E_Commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ProductDisplay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("productList")
    private ProductCategory productCategory;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "sell_count")
    @JsonIgnore
    private Integer sellCount;

    @Column(name = "cargo_price")
    private Float cargoPrice;

    @Column(name = "thumb")
    private String thumb;

    @Column(name = "date_created", insertable = false)
    @JsonIgnore
    private String dateCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
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

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public Float getCargoPrice() {
        return cargoPrice;
    }

    public void setCargoPrice(Float cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
