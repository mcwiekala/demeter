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

}
