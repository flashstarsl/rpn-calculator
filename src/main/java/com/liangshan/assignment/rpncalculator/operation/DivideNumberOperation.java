package com.liangshan.assignment.rpncalculator.operation;

import org.springframework.stereotype.Component;

/**
 * @author lianshan
 */
@Component
public class DivideNumberOperation extends TwoNumberOperation {

    @Override
    public double doOperate(double n1, double n2) throws Exception {
        if (n2 == 0) {
            throw new Exception(ZERO_DIVISOR);
        }
        return n1 / n2;
    }

}
