package io.mcwiekala.cleancode.domain;

import io.mcwiekala.cleancode.domain.Price.Currency;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class User {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Cart cart;

    public void order() {
        Price totalPrice = cart.calculateTotalPrice(Currency.USD);
        // ... logic related to order
    }

}
