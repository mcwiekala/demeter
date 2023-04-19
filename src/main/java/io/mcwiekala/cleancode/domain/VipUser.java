package io.mcwiekala.cleancode.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class VipUser extends User {

    private String extraMessage;
    private Integer numberOfDogs;

    @Override
    BigDecimal getTotalCartValueInUsd() {
        return BigDecimal.valueOf(1000);
    }

    public void goOnBusinessTrip(){

    }

    public void callTaxi(){

    }

    public static void main(String[] args) {
        User user = new User();
        VipUser vipUser = (VipUser) user;
        vipUser.callTaxi();
        vipUser.goOnBusinessTrip();
        System.out.println(vipUser.numberOfDogs);
    }
}
