package com.fxdeals.ClusteredDataWarehouse.repository;

import com.fxdeals.ClusteredDataWarehouse.entity.FxDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxDealsRepository extends JpaRepository<FxDeal,Long> {
}
