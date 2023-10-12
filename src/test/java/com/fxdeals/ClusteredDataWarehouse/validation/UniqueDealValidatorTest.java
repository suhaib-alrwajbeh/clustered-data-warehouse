package com.fxdeals.ClusteredDataWarehouse.validation;

import com.fxdeals.ClusteredDataWarehouse.dto.FxDealDTO;
import com.fxdeals.ClusteredDataWarehouse.repository.FxDealsRepository;
import com.fxdeals.ClusteredDataWarehouse.validation.impl.UniqueDealValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UniqueDealValidatorTest {
    private UniqueDealValidator validator;

    @Mock
    private FxDealsRepository fxDealsRepository;

    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        validator = new UniqueDealValidator(fxDealsRepository);
    }

    @Test
    public void testIsValidWhenDealDoesNotExist() {
        FxDealDTO dto = new FxDealDTO(123L, "USD", "EUR", null, BigDecimal.TEN);

        when(fxDealsRepository.existsById(dto.getDealId())).thenReturn(false);

        boolean result = validator.isValid(dto, context);

        assertTrue(result);
    }

    @Test
    public void testIsValidWhenDealExists() {
        FxDealDTO dto = new FxDealDTO(123L, "USD", "EUR", null, BigDecimal.TEN);

        when(fxDealsRepository.existsById(dto.getDealId())).thenReturn(true);

        boolean result = validator.isValid(dto, context);

        assertFalse(result);
    }
}
