package com.fxdeals.ClusteredDataWarehouse.controller;

import com.fxdeals.ClusteredDataWarehouse.dto.FxDealDTO;
import com.fxdeals.ClusteredDataWarehouse.service.FxDealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/")
public class FxDealController {

    private final FxDealService fxDealService;

    @PostMapping("/fx-deal")
    public ResponseEntity<FxDealDTO> saveDeal(@Valid @RequestBody FxDealDTO fxDealDTO) {
        log.info("REST-Request saveDeal to save a FxDeal with id: {}", fxDealDTO.getDealId());
        fxDealService.saveFxDeal(fxDealDTO);
        log.info("REST-Response saveDeal to save a FxDeal with id : {}", fxDealDTO.getDealId());
        return ResponseEntity.noContent().build();
    }
}
