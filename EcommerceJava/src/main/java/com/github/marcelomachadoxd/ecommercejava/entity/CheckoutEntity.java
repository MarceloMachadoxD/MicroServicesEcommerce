package com.github.marcelomachadoxd.ecommercejava.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Entity
@Data
public class CheckoutEntity {

    @Id
    private Long id;

    @Column
    private String code;


}
