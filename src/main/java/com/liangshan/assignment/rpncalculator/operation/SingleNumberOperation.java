package com.liangshan.assignment.rpncalculator.operation;

import java.util.Stack;

/**
 * @author lianshan
 */
public abstract class SingleNumberOperation extends AbstractOperation {

    public void operate() throws Exception {
        if (calculator == null || redoBuffer == null) {
            return;
        }
        Stack<String> numStack = calculator.getNumbers();
        if (numStack == null || numStack.size() < 1) {
            throw new Exception(INSUCIENT_PARAMATERS);
        }
        double n1 = Double.parseDouble(numStack.pop());
        calculator.pushNum(doOperate(n1));
        redoBuffer.addBuffer(calculator.getNumbers());
    }

    public abstract double doOperate(double n1) throws Exception;

}
