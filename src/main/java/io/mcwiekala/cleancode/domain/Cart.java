package io.mcwiekala.cleancode.domain;

import io.mcwiekala.cleancode.domain.Price.Currency;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class Cart {

    private List<Product> products;

    Price calculateValue(Currency currency){
        List<Price> prices = getAllProductPricesByCurrency(currency);
        CartValue cartValue = new CartValue(currency, prices);
        return cartValue.getPrice();
    }

    private List<Price> getAllProductPricesByCurrency(Currency currency) {
        return products.stream()
            .map(product -> product.getProductPriceByCurrency(currency))
            .toList();
    }

}
