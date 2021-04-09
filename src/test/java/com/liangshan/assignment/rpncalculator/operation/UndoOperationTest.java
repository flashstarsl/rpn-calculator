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

import java.util.Stack;

import static org.mockito.Mockito.when;

/**
 * @author lianshan
 */
public class UndoOperationTest {

    @InjectMocks
    private UndoOperation operation = new UndoOperation();

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
        operation.setRedoBuffer(null);
        calculator = new Calculator();
        operation.setCalculator(calculator);
        operation.operate();
        operation.setRedoBuffer(redoBuffer);
        when(redoBuffer.undo()).thenReturn(null);
        operation.operate();
        Assert.assertEquals(0, calculator.getNumbers().size());
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        when(redoBuffer.undo()).thenReturn(stack);
        operation.operate();
        Assert.assertEquals(2, calculator.getNumbers().size());
    }

}
