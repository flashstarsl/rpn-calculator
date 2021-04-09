package com.liangshan.assignment.rpncalculator.operation;

import org.springframework.stereotype.Component;

/**
 * @author lianshan
 */
@Component
public class MinusNumberOperation extends TwoNumberOperation {

    @Override
    public double doOperate(double n1, double n2) {
        return n1 - n2;
    }

}
