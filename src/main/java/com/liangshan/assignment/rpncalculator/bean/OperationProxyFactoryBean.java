package com.liangshan.assignment.rpncalculator.bean;

import com.google.common.collect.Maps;
import com.liangshan.assignment.rpncalculator.enums.OperationEnum;
import com.liangshan.assignment.rpncalculator.operation.IOperation;
import com.liangshan.assignment.rpncalculator.operation.proxy.OperationProxyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lianshan
 */
@Component("operationProxies")
public class OperationProxyFactoryBean implements FactoryBean<Map<String, IOperation>> {

    @Autowired
    private Calculator calculator;

    @Autowired
    private RedoBuffer redoBuffer;

    @Autowired
    private OperationProxyFactory operationProxyFactory;

    @Override
    public Map<String, IOperation> getObject() {
        Map<String, IOperation> operationMap = Maps.newHashMap();
        for (OperationEnum type : OperationEnum.values()) {
            IOperation operation = operationProxyFactory.createOperationProxy(type.getOperation(), calculator, redoBuffer);
            if (operation != null) {
                operationMap.put(type.getOperation(), operation);
            }
        }
        return operationMap;
    }

    @Override
    public Class<?> getObjectType() {
        return Map.class;
    }

}
