package io.mcwiekala.cleancode.domain;

import io.mcwiekala.cleancode.domain.Price.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class Product {

    private String productName;

    private PriceListPerCurrency priceListPerCurrency;

    Price getProductPriceByCurrency(Currency currency){
        return priceListPerCurrency.getPriceByCurrency(currency);
    }

}
