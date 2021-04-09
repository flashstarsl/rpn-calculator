package com.liangshan.assignment.rpncalculator.operation;

import org.springframework.stereotype.Component;

/**
 * @author lianshan
 */
@Component
public class SqrtOperation extends SingleNumberOperation {

    @Override
    public double doOperate(double n1) {
        return Math.sqrt(n1);
    }

}
