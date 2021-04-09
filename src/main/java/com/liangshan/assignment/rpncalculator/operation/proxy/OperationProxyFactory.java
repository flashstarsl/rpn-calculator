package com.liangshan.assignment.rpncalculator.operation.proxy;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;
import com.liangshan.assignment.rpncalculator.operation.AbstractOperation;
import com.liangshan.assignment.rpncalculator.operation.IOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author lianshan
 */
@Component
public class OperationProxyFactory {

    @Autowired
    private Map<String, AbstractOperation> operationMap;

    public IOperation createOperationProxy(String operation, Calculator calculator, RedoBuffer redoBuffer) {
        AbstractOperation target = operationMap.get(operation);
        return (IOperation) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{IOperation.class}, new OperationInvocation(target, calculator, redoBuffer));
    }

}
