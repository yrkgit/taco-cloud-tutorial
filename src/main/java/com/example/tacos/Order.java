package com.example.tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {

    @NotBlank(message = "Podaj imie i nazwisko")
    private String name;

    @NotBlank(message = "Podaj ulicę")
    private String street;

    @NotBlank(message = "Podaj miasto")
    private String city;

    @NotBlank(message = "Podaj województwo")
    private String state;

    @NotBlank(message = "Podaj kod")
    private String zip;

    @CreditCardNumber(message = "Nieprawidłowy nr karty")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

}
