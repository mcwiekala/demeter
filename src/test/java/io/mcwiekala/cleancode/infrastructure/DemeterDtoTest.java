package io.mcwiekala.cleancode.infrastructure;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.mcwiekala.cleancode.infrastructure.PriceDto.Currency;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DemeterDtoTest {

    @Test
    void shouldReturnTotalUsdCartDtoValue() {
        // given
        ProductDto tv = aTvDto();
        ProductDto iphone = anIphoneDto();
        ProductDto table = aTableDto();

        List<ProductDto> ProductDtos = List.of(tv, iphone, table);
        CartDto CartDto = new CartDto(ProductDtos);
        UserDto michael = new UserDto(CartDto);

        // when
        BigDecimal cartValue = michael.getCartDto().getProductDtos().stream()
            .map(ProductDto::getPriceListPerCurrencyDto)
            .flatMap(priceList -> priceList.getPriceDtos().stream())
            .filter(price -> price.getCurrency() == PriceDto.Currency.USD)
            .map(PriceDto::getAmount)
            .reduce(BigDecimal.valueOf(0), BigDecimal::add);

        // then
        assertThat(cartValue).isEqualTo(BigDecimal.valueOf(1900));
    }

    private static ProductDto aTvDto() {
        List<PriceDto> tvPriceDtos = new ArrayList<>();
        tvPriceDtos.add(new PriceDto(Currency.USD, BigDecimal.valueOf(500)));
        tvPriceDtos.add(new PriceDto(Currency.EUR, BigDecimal.valueOf(600)));
        tvPriceDtos.add(new PriceDto(Currency.CHF, BigDecimal.valueOf(600)));
        tvPriceDtos.add(new PriceDto(Currency.GBP, BigDecimal.valueOf(400)));
        PriceListPerCurrencyDto tvPriceListPerCurrencyDto = new PriceListPerCurrencyDto(tvPriceDtos);
        ProductDto tv = new ProductDto(tvPriceListPerCurrencyDto);
        return tv;
    }

    private static ProductDto anIphoneDto() {
        List<PriceDto> iphonePriceDtos = new ArrayList<>();
        iphonePriceDtos.add(new PriceDto(Currency.USD, BigDecimal.valueOf(1000)));
        iphonePriceDtos.add(new PriceDto(Currency.EUR, BigDecimal.valueOf(900)));
        iphonePriceDtos.add(new PriceDto(Currency.CHF, BigDecimal.valueOf(900)));
        iphonePriceDtos.add(new PriceDto(Currency.GBP, BigDecimal.valueOf(800)));
        PriceListPerCurrencyDto iphonePriceListPerCurrencyDto = new PriceListPerCurrencyDto(iphonePriceDtos);
        ProductDto iphone = new ProductDto(iphonePriceListPerCurrencyDto);
        return iphone;
    }

    private static ProductDto aTableDto() {
        List<PriceDto> tablePriceDtos = new ArrayList<>();
        tablePriceDtos.add(new PriceDto(Currency.USD, BigDecimal.valueOf(400)));
        tablePriceDtos.add(new PriceDto(Currency.EUR, BigDecimal.valueOf(300)));
        tablePriceDtos.add(new PriceDto(Currency.CHF, BigDecimal.valueOf(300)));
        tablePriceDtos.add(new PriceDto(Currency.GBP, BigDecimal.valueOf(250)));
        PriceListPerCurrencyDto tablePriceListPerCurrencyDto = new PriceListPerCurrencyDto(tablePriceDtos);
        ProductDto table = new ProductDto(tablePriceListPerCurrencyDto);
        return table;
    }

}
