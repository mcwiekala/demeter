package io.mcwiekala.cleancode.domain;

import io.mcwiekala.cleancode.domain.Price.Currency;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class CartValue {

    private Price price;

    CartValue(Currency currency, List<Price> productPrices) {
        this.price = calculateCartValue(currency, productPrices);
    }

    private Price calculateCartValue(Currency currency, List<Price> productPrices) {
        validatePrices(currency, productPrices);
        return calculateTotalPrice(currency, productPrices);
    }

    private static void validatePrices(Currency currency, List<Price> prices) {
        boolean pricesInDifferentCurrencies = prices.stream()
            .allMatch(price -> price.getCurrency() != currency);
        if (pricesInDifferentCurrencies) {
            throw new IllegalStateException("All product in cart must have same currency");
        }
    }

    private static Price calculateTotalPrice(Currency currency, List<Price> prices) {
        Price zeroValue = new Price(currency, BigDecimal.ZERO);
        Price totalPrice = prices.stream()
            .reduce(zeroValue, Price::addPrice);
        return totalPrice;
    }

}
