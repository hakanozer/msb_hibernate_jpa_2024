package com.works.repositories;

import com.works.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceGreaterThanOrSortContainsIgnoreCase(Integer price, String sort);

    List<Product> findByPriceGreaterThan(Integer price);

    // Custom query
    @Query(value = "select * from PUBLIC.PRODUCT where TITLE like ?1 or SORT like ?2", nativeQuery = true)
    List<Product> titleDetailSearch(String title, String sort);

}