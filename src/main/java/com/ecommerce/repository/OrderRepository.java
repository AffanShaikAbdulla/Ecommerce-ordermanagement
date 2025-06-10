package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.Order;
import com.ecommerce.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query("SELECT o FROM orer o where o.status=:status")
	List<Order> findByStatsus(OrderStatus status);

	List<Order> findByUserId(Long userId);
}
