package com.liangshan.assignment.rpncalculator.operation.proxy;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;
import com.liangshan.assignment.rpncalculator.operation.AbstractOperation;
import com.liangshan.assignment.rpncalculator.operation.AddNumberOperation;
import com.liangshan.assignment.rpncalculator.operation.IOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author lianshan
 */
public class OperationProxyFactoryTest {

    @InjectMocks
    private OperationProxyFactory factory = new OperationProxyFactory();

    @Mock
    private Map<String, AbstractOperation> operationMap;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOperationProxy() throws Exception {
        AddNumberOperation operation = new AddNumberOperation();
        when(operationMap.get(eq("addNumberOperation"))).thenReturn(operation);
        Calculator calculator = new Calculator();
        calculator.pushNum(1);
        calculator.pushNum(2);
        IOperation op = factory.createOperationProxy("addNumberOperation", calculator, new RedoBuffer(10));
        Assert.assertNotNull(op);
        op.operate();
        Assert.assertEquals(1, calculator.getNumbers().size());
        Assert.assertEquals("3", calculator.getNumbers().peek());

    }

}
