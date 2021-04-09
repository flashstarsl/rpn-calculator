package com.liangshan.assignment.rpncalculator.operation;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * @author lianshan
 */
@Component
public class RedoOperation extends AbstractOperation {

    @Override
    public void operate() {
        if (calculator == null || redoBuffer == null) {
            return;
        }
        Stack<String> redo = redoBuffer.redo();
        if (redo != null) {
            Stack<String> copy = new Stack<>();
            copy.addAll(redo);
            calculator.setNumbers(copy);
        }
    }

}
