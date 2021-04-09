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
public class MinusNumberOperationTest {

    @InjectMocks
    private MinusNumberOperation operation = new MinusNumberOperation();

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
        operation.setRedoBuffer(redoBuffer);
        calculator = new Calculator();
        operation.setCalculator(calculator);
        calculator.pushNum(14);
        calculator.pushNum(6);
        operation.operate();
        Assert.assertEquals(1, calculator.getNumbers().size());
        Assert.assertEquals("8", calculator.getNumbers().peek());
    }

}
