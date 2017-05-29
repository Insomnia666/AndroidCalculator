package android.kunitsa.com.androidcalculator;

import java.math.BigDecimal;

/**
 * Created by Vladimir on 25.05.2017.
 * Test Calculator
 */

class Calculate {

    BigDecimal plus(BigDecimal one, BigDecimal two) {
        return one.add(two);
    }

    BigDecimal minus(BigDecimal one, BigDecimal two) {
        return one.subtract(two);
    }

    BigDecimal multiply(BigDecimal one, BigDecimal two) {
        return one.multiply(two);
    }

    BigDecimal devide(BigDecimal one, BigDecimal two) {
        return one.divide(two, 5, BigDecimal.ROUND_HALF_UP);
    }

    BigDecimal exponent(BigDecimal one, BigDecimal two){
        BigDecimal value = new BigDecimal(1);
        for (int i=0; i < two.intValue(); i++)
            value=value.multiply(one);
        return value;
    }
}
