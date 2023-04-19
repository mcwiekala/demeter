package io.mcwiekala.cleancode.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class Price {

    private Currency currency;
    private BigDecimal amount;

    enum Currency {
        USD, EUR, GBP, CHF
    }

    Price addPrice(Price priceToAdd) {
        if (currency != priceToAdd.getCurrency()) {
            throw new IllegalStateException("Cannot add prices with different Currencies");
        }
        return new Price(currency, amount.add(priceToAdd.getAmount()));
    }

}
