package io.mcwiekala.cleancode.infrastructure;

import io.mcwiekala.cleancode.infrastructure.PriceDto.Currency;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class UserDto {

    private CartDto cartDto;

}
