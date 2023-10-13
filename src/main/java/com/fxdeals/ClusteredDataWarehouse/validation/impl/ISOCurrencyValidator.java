package com.fxdeals.ClusteredDataWarehouse.validation.impl;

import com.fxdeals.ClusteredDataWarehouse.validation.ISOCurrency;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Currency;
import java.util.Set;
import java.util.stream.Collectors;


public class ISOCurrencyValidator implements ConstraintValidator<ISOCurrency, String> {

    private Set<String> availableCurrencyCodes;

    @Override
    public void initialize(ISOCurrency constraintAnnotation) {
        availableCurrencyCodes = Currency.getAvailableCurrencies()
            .stream()
            .map(Currency::getCurrencyCode)
            .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return availableCurrencyCodes.contains(value);
    }
}
