package io.mcwiekala.cleancode.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.mcwiekala.cleancode.domain.Price.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DemeterTest {

    @Test
    void shouldReturnTotalUsdCartValue() {
        // given
        io.mcwiekala.cleancode.domain.ProductDto tv = aTv();
        io.mcwiekala.cleancode.domain.ProductDto iphone = anIphone();
        io.mcwiekala.cleancode.domain.ProductDto table = aTable();

        List<io.mcwiekala.cleancode.domain.ProductDto> products = List.of(tv, iphone, table);
        Cart cart = new Cart(products);
        User michael = new User(cart);

        // when
        BigDecimal cartValue = michael.getTotalCartValueInUsd();

        // then
        assertThat(cartValue).isEqualTo(BigDecimal.valueOf(1900));
    }

    @Test
    void checkUserBuilder() {
        User tom = User.builder()
            .name("Tom")
            .surname("Doe")
            .dateOfBirth(LocalDate.of(1976, 12, 3))
            .build();
    }

    private static io.mcwiekala.cleancode.domain.ProductDto aTv() {
        List<Price> tvPrices = new ArrayList<>();
        tvPrices.add(new Price(Currency.USD, BigDecimal.valueOf(500)));
        tvPrices.add(new Price(Currency.EUR, BigDecimal.valueOf(600)));
        tvPrices.add(new Price(Currency.CHF, BigDecimal.valueOf(600)));
        tvPrices.add(new Price(Currency.GBP, BigDecimal.valueOf(400)));
        PriceListPerCurrency tvPriceListPerCurrency = new PriceListPerCurrency(tvPrices);
        io.mcwiekala.cleancode.domain.ProductDto tv = new io.mcwiekala.cleancode.domain.ProductDto(
            tvPriceListPerCurrency);
        return tv;
    }

    private static io.mcwiekala.cleancode.domain.ProductDto anIphone() {
        List<Price> iphonePrices = new ArrayList<>();
        iphonePrices.add(new Price(Currency.USD, BigDecimal.valueOf(1000)));
        iphonePrices.add(new Price(Currency.EUR, BigDecimal.valueOf(900)));
        iphonePrices.add(new Price(Currency.CHF, BigDecimal.valueOf(900)));
        iphonePrices.add(new Price(Currency.GBP, BigDecimal.valueOf(800)));
        PriceListPerCurrency iphonePriceListPerCurrency = new PriceListPerCurrency(iphonePrices);
        io.mcwiekala.cleancode.domain.ProductDto iphone = new io.mcwiekala.cleancode.domain.ProductDto(
            iphonePriceListPerCurrency);
        return iphone;
    }

    private static io.mcwiekala.cleancode.domain.ProductDto aTable() {
        List<Price> tablePrices = new ArrayList<>();
        tablePrices.add(new Price(Currency.USD, BigDecimal.valueOf(400)));
        tablePrices.add(new Price(Currency.EUR, BigDecimal.valueOf(300)));
        tablePrices.add(new Price(Currency.CHF, BigDecimal.valueOf(300)));
        tablePrices.add(new Price(Currency.GBP, BigDecimal.valueOf(250)));
        PriceListPerCurrency tablePriceListPerCurrency = new PriceListPerCurrency(tablePrices);
        io.mcwiekala.cleancode.domain.ProductDto table = new io.mcwiekala.cleancode.domain.ProductDto(
            tablePriceListPerCurrency);
        return table;
    }

}
