package io.mcwiekala.cleancode.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class CheckoutDto {

    private CartDto cartDto;

}
