package com.github.marcelomachadoxd.ecommercejava.service;

import com.github.marcelomachadoxd.ecommercejava.entity.CheckoutEntity;
import com.github.marcelomachadoxd.ecommercejava.resource.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
