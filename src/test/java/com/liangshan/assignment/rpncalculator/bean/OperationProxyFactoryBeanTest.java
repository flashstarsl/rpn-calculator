package com.liangshan.assignment.rpncalculator.bean;

import com.liangshan.assignment.rpncalculator.enums.OperationEnum;
import com.liangshan.assignment.rpncalculator.operation.AbstractOperation;
import com.liangshan.assignment.rpncalculator.operation.IOperation;
import com.liangshan.assignment.rpncalculator.operation.proxy.OperationProxyFactory;
import org.apache.commons.collections.MapUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author lianshan
 */
public class OperationProxyFactoryBeanTest {

    @InjectMocks
    private OperationProxyFactoryBean factoryBean = new OperationProxyFactoryBean();

    @Mock
    private Calculator calculator;

    @Mock
    private RedoBuffer redoBuffer;

    @Mock
    private OperationProxyFactory operationProxyFactory;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetObject() {
        when(operationProxyFactory.createOperationProxy(anyString(), eq(calculator), eq(redoBuffer))).thenReturn(new AbstractOperation() {
            @Override
            public void operate() {}
        });
        Map<String, IOperation> map = factoryBean.getObject();
        Assert.assertEquals(OperationEnum.values().length, MapUtils.isEmpty(map) ? 0 : map.size());
    }

    @Test
    public void testGetObjectType() {
        Assert.assertEquals(Map.class, factoryBean.getObjectType());
    }

}
