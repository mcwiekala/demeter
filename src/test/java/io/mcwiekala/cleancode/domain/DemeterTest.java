package io.mcwiekala.cleancode.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.mcwiekala.cleancode.domain.Price.Currency;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DemeterTest {

    @Test
    void shouldReturnTotalUsdCartValue() {
        // given
        Product tv = aTv();
        Product iphone = anIphone();
        Product table = aTable();

        List<Product> products = List.of(tv, iphone, table);
        Cart cart = new Cart(products);

        // when
        Price cartValue = cart.calculateTotalPrice(Currency.USD);

        // then
        assertThat(cartValue.getAmount()).isEqualTo(BigDecimal.valueOf(1900));
    }

    private static Product aTv() {
        List<Price> tvPrices = new ArrayList<>();
        tvPrices.add(new Price(Currency.USD, BigDecimal.valueOf(500)));
        tvPrices.add(new Price(Currency.EUR, BigDecimal.valueOf(600)));
        tvPrices.add(new Price(Currency.CHF, BigDecimal.valueOf(600)));
        tvPrices.add(new Price(Currency.GBP, BigDecimal.valueOf(400)));
        PriceListPerCurrency tvPriceListPerCurrency = new PriceListPerCurrency(tvPrices);
        Product tv = new Product("tv", tvPriceListPerCurrency);
        return tv;
    }

    private static Product anIphone() {
        List<Price> iphonePrices = new ArrayList<>();
        iphonePrices.add(new Price(Currency.USD, BigDecimal.valueOf(1000)));
        iphonePrices.add(new Price(Currency.EUR, BigDecimal.valueOf(900)));
        iphonePrices.add(new Price(Currency.CHF, BigDecimal.valueOf(900)));
        iphonePrices.add(new Price(Currency.GBP, BigDecimal.valueOf(800)));
        PriceListPerCurrency iphonePriceListPerCurrency = new PriceListPerCurrency(iphonePrices);
        Product iphone = new Product("iphone", iphonePriceListPerCurrency);
        return iphone;
    }

    private static Product aTable() {
        List<Price> tablePrices = new ArrayList<>();
        tablePrices.add(new Price(Currency.USD, BigDecimal.valueOf(400)));
        tablePrices.add(new Price(Currency.EUR, BigDecimal.valueOf(300)));
        tablePrices.add(new Price(Currency.CHF, BigDecimal.valueOf(300)));
        tablePrices.add(new Price(Currency.GBP, BigDecimal.valueOf(250)));
        PriceListPerCurrency tablePriceListPerCurrency = new PriceListPerCurrency(tablePrices);
        Product table = new Product("table", tablePriceListPerCurrency);
        return table;
    }

}
