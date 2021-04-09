package com.liangshan.assignment.rpncalculator.operation;

import org.springframework.stereotype.Component;

/**
 * @author lianshan
 */
@Component
public class ClearOperation extends AbstractOperation {

    @Override
    public void operate() {
        if (calculator == null || calculator.getNumbers() == null || redoBuffer == null) {
            return;
        }
        if (!calculator.getNumbers().isEmpty()) {
            calculator.getNumbers().clear();
            redoBuffer.addBuffer(calculator.getNumbers());
        }
    }

}
