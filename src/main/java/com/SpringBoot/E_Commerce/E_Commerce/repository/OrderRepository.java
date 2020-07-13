package com.SpringBoot.E_Commerce.E_Commerce.repository;

import com.SpringBoot.E_Commerce.E_Commerce.model.Order;
import com.SpringBoot.E_Commerce.E_Commerce.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface OrderRepository  extends PagingAndSortingRepository<Order, Integer> {

    List<Order> findAllByUserOrderByDateDesc(User user, Pageable pageable);

    Integer countAllByUser(User user);
}
