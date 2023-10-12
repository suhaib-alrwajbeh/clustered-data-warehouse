package com.fxdeals.ClusteredDataWarehouse.mapper;

import com.fxdeals.ClusteredDataWarehouse.entity.FxDeal;
import com.fxdeals.ClusteredDataWarehouse.dto.FxDealDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface FxDealMapper {

    @Mapping(target= "date", qualifiedByName = "mapDate")
    FxDeal toEntity(FxDealDTO dto);

    @Named("mapDate")
    static ZonedDateTime mapDate(ZonedDateTime date){
        if (date == null){
            return ZonedDateTime.now();
        }
        return date;
    }

}
