package com.github.marcelomachadoxd.ecommercejava.repository;

import com.github.marcelomachadoxd.ecommercejava.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {
}
