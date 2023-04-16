package io.mcwiekala.cleancode.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class ProductDto {

    private PriceListPerCurrency priceListPerCurrency;

}
