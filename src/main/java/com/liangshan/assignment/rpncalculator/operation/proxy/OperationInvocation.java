package com.liangshan.assignment.rpncalculator.operation.proxy;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;
import com.liangshan.assignment.rpncalculator.operation.AbstractOperation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lianshan
 */
public class OperationInvocation implements InvocationHandler {

    private AbstractOperation target;

    public OperationInvocation(AbstractOperation target, Calculator calculator, RedoBuffer redoBuffer) {
        this.target = target;
        target.setCalculator(calculator);
        target.setRedoBuffer(redoBuffer);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target, args);
        return null;
    }

}
