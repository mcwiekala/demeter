package io.mcwiekala.cleancode.infrastructure;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class CartDto {

    private List<ProductDto> productDtos;

}
