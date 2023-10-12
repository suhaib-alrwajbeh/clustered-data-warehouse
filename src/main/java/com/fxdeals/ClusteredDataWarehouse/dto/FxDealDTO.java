package com.fxdeals.ClusteredDataWarehouse.dto;

import com.fxdeals.ClusteredDataWarehouse.validation.UniqueDeal;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UniqueDeal
public class FxDealDTO {

    @NotNull
    private Long dealId;

    @NotNull(message = "orderingCurrency cannot be null")
    private String orderingCurrency;

    @NotNull(message = "toCurrency cannot be null")
    private String toCurrency;

    private ZonedDateTime date;

    @NotNull(message = "amount cannot be null")
    private BigDecimal amount;
}
