package com.liangshan.assignment.rpncalculator.operation;

import java.util.Stack;

/**
 * @author lianshan
 */
public abstract class TwoNumberOperation extends AbstractOperation {

    public void operate() throws Exception {
        if (calculator == null || redoBuffer == null) {
            return;
        }
        Stack<String> numStack = calculator.getNumbers();
        if (numStack == null || numStack.size() < 2) {
            throw new Exception(INSUCIENT_PARAMATERS);
        }
        double n2 = Double.parseDouble(numStack.pop());
        double n1 = Double.parseDouble(numStack.pop());
        calculator.pushNum(doOperate(n1, n2));
        redoBuffer.addBuffer(calculator.getNumbers());
    }

    public abstract double doOperate(double n1, double n2) throws Exception;

}
