package com.SpringBoot.E_Commerce.E_Commerce.repository;

import com.SpringBoot.E_Commerce.E_Commerce.model.ProductCategory;
import com.SpringBoot.E_Commerce.E_Commerce.model.ProductDisplay;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDisplayRepository extends JpaRepository<ProductDisplay,Integer> {
    List<ProductDisplay> findAllByProductCategory(Pageable pageable, ProductCategory productCategory);

    List<ProductDisplay> findTop8ByOrderByDateCreatedDesc();

    List<ProductDisplay> findTop8ByOrderBySellCountDesc();

    List<ProductDisplay> findTop8ByProductCategoryAndIdIsNotOrderBySellCountDesc(ProductCategory productCategory, Long id);

    List<ProductDisplay> findAllByProductCategoryIsNotOrderBySellCountDesc(ProductCategory productCategory, Pageable pageable);

    List<ProductDisplay> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

}
