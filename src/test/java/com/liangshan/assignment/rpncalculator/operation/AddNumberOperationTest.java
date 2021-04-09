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
public class AddNumberOperationTest {

    @InjectMocks
    private AddNumberOperation operation = new AddNumberOperation();

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
        operation.setCalculator(null);
        operation.setRedoBuffer(null);
        Assert.assertNull(operation.getCalculator());
        Assert.assertNull(operation.getRedoBuffer());
        operation.operate();
        calculator = new Calculator();
        operation.setCalculator(calculator);
        operation.setRedoBuffer(redoBuffer);
        Assert.assertNotNull(operation.getCalculator());
        Assert.assertNotNull(operation.getRedoBuffer());
        try {
            operation.operate();
        } catch (Exception ignored) {}
        calculator.pushNum(7);
        calculator.pushNum(8);
        operation.operate();
        Assert.assertEquals(1, calculator.getNumbers().size());
        Assert.assertEquals("15", calculator.getNumbers().peek());
    }

}
