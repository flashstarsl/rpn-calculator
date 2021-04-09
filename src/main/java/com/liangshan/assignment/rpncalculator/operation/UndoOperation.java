package com.liangshan.assignment.rpncalculator.operation;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * @author lianshan
 */
@Component
public class UndoOperation extends AbstractOperation {

    @Override
    public void operate() {
        if (calculator == null || redoBuffer == null) {
            return;
        }
        Stack<String> undo = redoBuffer.undo();
        if (undo != null) {
            Stack<String> copy = new Stack<>();
            copy.addAll(undo);
            calculator.setNumbers(copy);
        }
    }

}
