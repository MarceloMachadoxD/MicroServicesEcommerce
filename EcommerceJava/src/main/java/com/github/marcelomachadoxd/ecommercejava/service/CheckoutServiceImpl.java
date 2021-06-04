package com.github.marcelomachadoxd.ecommercejava.service;

import com.github.marcelomachadoxd.ecommercejava.CheckoutCreatedSource;
import com.github.marcelomachadoxd.ecommercejava.entity.CheckoutEntity;
import com.github.marcelomachadoxd.ecommercejava.repository.CheckoutRepository;
import com.github.marcelomachadoxd.ecommercejava.resource.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {

        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
            .code(UUID.randomUUID().toString())
            .status(CheckoutEntity.Status.CREATED)
            .build();

        final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);

        //verificar por que não está importando a classe gerada pelo avro

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
            .setCheckoutCode(entity.getCode())
            .setStatus(entity.getStatus().name())
            .build();
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());


        return Optional.of(entity);
    }
}
