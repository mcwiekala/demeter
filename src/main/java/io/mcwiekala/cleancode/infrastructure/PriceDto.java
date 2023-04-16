package io.mcwiekala.cleancode.infrastructure;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class PriceDto {

    private Currency currency;
    private BigDecimal amount;

    enum Currency {
        USD, EUR, GBP, CHF
    }

}
