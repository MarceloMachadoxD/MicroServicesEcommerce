package com.github.marcelomachadoxd.ecommercejava.service;

import com.github.marcelomachadoxd.ecommercejava.entity.CheckoutEntity;
import com.github.marcelomachadoxd.ecommercejava.repository.CheckoutRepository;
import com.github.marcelomachadoxd.ecommercejava.resource.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {

        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
            .code(UUID.randomUUID().toString())
            .build();
        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
