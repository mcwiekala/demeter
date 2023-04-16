package io.mcwiekala.cleancode.domain;

import io.mcwiekala.cleancode.domain.Price.Currency;
import java.math.BigDecimal;
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

    User(Cart cart) {
        this.cart = cart;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    BigDecimal getTotalCartValueInUsd() {
        return cart.getProducts().stream()
            .map(ProductDto::getPriceListPerCurrency)
            .flatMap(priceList -> priceList.getPrices().stream())
            .filter(price -> price.getCurrency() == Currency.USD)
            .map(Price::getAmount)
            .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    public static class UserBuilder {

        private String name;
        private String surname;
        private LocalDate dateOfBirth;
        private Cart cart;

        UserBuilder() {
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserBuilder cart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public User build() {
            return new User(name, surname, dateOfBirth, cart);
        }

        public String toString() {
            return "User.UserBuilder(name=" + this.name + ", surname=" + this.surname + ", dateOfBirth="
                + this.dateOfBirth
                + ", cart=" + this.cart + ")";
        }
    }
}
