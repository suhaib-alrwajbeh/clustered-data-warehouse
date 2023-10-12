package com.fxdeals.ClusteredDataWarehouse.validation.impl;

import com.fxdeals.ClusteredDataWarehouse.dto.FxDealDTO;
import com.fxdeals.ClusteredDataWarehouse.repository.FxDealsRepository;
import com.fxdeals.ClusteredDataWarehouse.validation.UniqueDeal;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UniqueDealValidator implements ConstraintValidator<UniqueDeal, FxDealDTO> {

    private final FxDealsRepository fxDealsRepository;

    @Override
    public boolean isValid(FxDealDTO fxDealDTO, ConstraintValidatorContext context) {
        if (fxDealDTO == null){
            return false;
        }
        return !fxDealsRepository.existsById(fxDealDTO.getDealId());
    }
}
