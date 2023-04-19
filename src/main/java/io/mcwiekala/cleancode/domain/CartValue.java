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

    CartValue(Currency currency, List<Price> prices) {
        this.price = calculateCartValue(currency, prices);
    }

    private Price calculateCartValue(Currency currency, List<Price> prices) {
        validatePrices(currency, prices);
        return calculateTotalPrice(currency, prices);
    }

    private static Price calculateTotalPrice(Currency currency, List<Price> prices) {
        Price zeroValue = new Price(currency, BigDecimal.ZERO);
        Price totalPrice = prices.stream()
            .reduce(zeroValue, Price::addPrice);
        return totalPrice;
    }

    private static void validatePrices(Currency currency, List<Price> prices) {
        boolean pricesInDifferentCurrencies = prices.stream()
            .allMatch(price -> price.getCurrency() != currency);
        if (pricesInDifferentCurrencies) {
            throw new IllegalStateException("All product in cart must have same currency");
        }
    }

}
