package com.fxdeals.ClusteredDataWarehouse.service;

import com.fxdeals.ClusteredDataWarehouse.entity.FxDeal;
import com.fxdeals.ClusteredDataWarehouse.repository.FxDealsRepository;
import com.fxdeals.ClusteredDataWarehouse.dto.FxDealDTO;
import com.fxdeals.ClusteredDataWarehouse.mapper.FxDealMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FxDealService {

    private final FxDealsRepository fxDealsRepository;
    private final FxDealMapper fxDealMapper;

    public void saveFxDeal(FxDealDTO fxDealDTO){
        log.debug("Request to save a FxDeal : {}", fxDealDTO);
        FxDeal fxdeal = fxDealMapper.toEntity(fxDealDTO);
        fxDealsRepository.save(fxdeal);
        log.debug("Response to saved in database a FxDeal : {}", fxdeal);
    }
}
