package com.anisimov.denis.spring.cloud.repositories;

import com.anisimov.denis.spring.cloud.enteties.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
