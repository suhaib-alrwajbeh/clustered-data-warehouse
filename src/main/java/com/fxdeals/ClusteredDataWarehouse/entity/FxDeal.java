package com.fxdeals.ClusteredDataWarehouse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "fx_deals")
public class FxDeal {

    @Id

    @Column(name = "deal_id")
    private Long dealId;

    @Column(name = "ordering_currency")
    private String orderingCurrency;

    @Column(name = "to_currency")
    private String toCurrency;

    @Column(name = "date")
    private ZonedDateTime date;

    @Column(name = "amount")
    private BigDecimal amount;

}
