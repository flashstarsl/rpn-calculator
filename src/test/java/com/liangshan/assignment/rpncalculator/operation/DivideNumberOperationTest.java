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
public class DivideNumberOperationTest {

    @InjectMocks
    private DivideNumberOperation operation = new DivideNumberOperation();

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
        calculator.pushNum(12);
        calculator.pushNum(0);
        try {
            operation.operate();
        } catch (Exception ignored) {}
        calculator.pushNum(12);
        calculator.pushNum(2);
        operation.operate();
        Assert.assertEquals(1, calculator.getNumbers().size());
        Assert.assertEquals("6", calculator.getNumbers().peek());
    }

}
