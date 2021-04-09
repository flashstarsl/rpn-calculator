package com.liangshan.assignment.rpncalculator.operation;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;

/**
 * @author lianshan
 */
public abstract class AbstractOperation implements IOperation {

    protected static final String INSUCIENT_PARAMATERS = "insucient parameters";
    protected static final String ZERO_DIVISOR = "zero divisor";

    protected Calculator calculator;
    protected RedoBuffer redoBuffer;

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public RedoBuffer getRedoBuffer() {
        return redoBuffer;
    }

    public void setRedoBuffer(RedoBuffer redoBuffer) {
        this.redoBuffer = redoBuffer;
    }

}
