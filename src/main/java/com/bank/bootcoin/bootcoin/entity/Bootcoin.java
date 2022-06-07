package com.bank.bootcoin.bootcoin.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(value = "BOOTCOIN")
public class Bootcoin {

    @Id
    private String  id;                // Identificador bootcoin
    private Integer mobile;            // numero movil
    private Integer documentNumber;    // Dni - Cex - pasaporte
    private String  email;             // Correo personal
    private Double balance;            // Saldo de bootcoin
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate     dateStar;    // Fecha de creacion de la cuenta yanki
    
}
