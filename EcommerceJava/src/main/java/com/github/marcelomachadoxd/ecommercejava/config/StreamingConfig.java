package com.github.marcelomachadoxd.ecommercejava.config;


import com.github.marcelomachadoxd.ecommercejava.CheckoutCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration

@EnableBinding(value = {
    CheckoutCreatedSource.class,
    //PaymentPaidSink.class
})


public class StreamingConfig {
}
