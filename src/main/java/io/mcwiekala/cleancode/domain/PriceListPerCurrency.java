package io.mcwiekala.cleancode.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class PriceListPerCurrency {

    private List<Price> prices;

}
