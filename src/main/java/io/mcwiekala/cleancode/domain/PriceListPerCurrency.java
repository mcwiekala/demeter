package io.mcwiekala.cleancode.domain;

import io.mcwiekala.cleancode.domain.Price.Currency;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class PriceListPerCurrency {

    private List<Price> prices;

    Price getPriceByCurrency(Currency currency) {
        Optional<Price> possiblePrice = prices.stream()
            .filter(price -> price.getCurrency() == currency)
            .findFirst();
        return possiblePrice.orElseThrow(
            () -> new RuntimeException("Price for currency [%s] not found".formatted(currency)));

    }

}
