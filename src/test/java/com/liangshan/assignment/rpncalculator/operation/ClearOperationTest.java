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
public class ClearOperationTest {

    @InjectMocks
    private ClearOperation operation = new ClearOperation();

    @Spy
    private Calculator calculator;

    @Mock
    private RedoBuffer redoBuffer;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testOperate() {
        calculator = new Calculator();
        operation.setCalculator(calculator);
        operation.setRedoBuffer(null);
        operation.operate();
        operation.setRedoBuffer(redoBuffer);
        operation.operate();
        calculator.pushNum(123);
        operation.operate();
        Assert.assertEquals(0, calculator.getNumbers().size());
    }

}
