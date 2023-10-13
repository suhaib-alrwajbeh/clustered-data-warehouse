package com.fxdeals.ClusteredDataWarehouse.validation;

import com.fxdeals.ClusteredDataWarehouse.validation.impl.ISOCurrencyValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ISOCurrencyValidatorTest {
    private ISOCurrencyValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new ISOCurrencyValidator();
        validator.initialize(null);
    }

    @Test
    public void testValidISOCurrency() {
        assertTrue(validator.isValid("USD", null)); // USD is a valid ISO currency code
        assertTrue(validator.isValid("EUR", null)); // EUR is a valid ISO currency code
    }

    @Test
    public void testInvalidISOCurrency() {
        assertFalse(validator.isValid("XYZ", null)); // XYZ is not a valid ISO currency code
    }

}
