package com.liangshan.assignment.rpncalculator.operation;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author lianshan
 */
public class SqrtOperationTest {

    @InjectMocks
    private SqrtOperation operation = new SqrtOperation();

    @Spy
    private Calculator calculator;

    @Mock
    private RedoBuffer redoBuffer;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testOperate() throws Exception {
        operation.setRedoBuffer(null);
        calculator = new Calculator();
        operation.setCalculator(calculator);
        operation.operate();
        operation.setRedoBuffer(redoBuffer);
        try {
            operation.operate();
        } catch (Exception ignored) {}
        calculator.pushNum(25);
        operation.operate();
        Assert.assertEquals(1, calculator.getNumbers().size());
        Assert.assertEquals("5", calculator.getNumbers().peek());
    }

}
