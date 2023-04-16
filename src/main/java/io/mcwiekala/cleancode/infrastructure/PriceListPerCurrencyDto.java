package io.mcwiekala.cleancode.infrastructure;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class PriceListPerCurrencyDto {

    private List<PriceDto> priceDtos;

}
