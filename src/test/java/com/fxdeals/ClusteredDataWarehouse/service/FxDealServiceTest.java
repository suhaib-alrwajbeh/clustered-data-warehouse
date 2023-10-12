package com.fxdeals.ClusteredDataWarehouse.service;

import com.fxdeals.ClusteredDataWarehouse.dto.FxDealDTO;
import com.fxdeals.ClusteredDataWarehouse.entity.FxDeal;
import com.fxdeals.ClusteredDataWarehouse.mapper.FxDealMapper;
import com.fxdeals.ClusteredDataWarehouse.repository.FxDealsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class FxDealServiceTest {

    @InjectMocks
    private FxDealService fxDealService;

    @Mock
    private FxDealMapper fxDealMapper;

    @Mock
    private FxDealsRepository fxDealsRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveFxDeal() {
        FxDealDTO dto = new FxDealDTO(123L, "USD", "EUR", null, BigDecimal.TEN);
        FxDeal fxDeal = new FxDeal();

        when(fxDealMapper.toEntity(dto)).thenReturn(fxDeal);

        fxDealService.saveFxDeal(dto);

        verify(fxDealMapper, times(1)).toEntity(dto);
        verify(fxDealsRepository, times(1)).save(fxDeal);
    }
}
