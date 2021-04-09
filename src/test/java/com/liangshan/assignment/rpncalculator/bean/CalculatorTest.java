package com.liangshan.assignment.rpncalculator.bean;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Stack;

/**
 * @author lianshan
 */
public class CalculatorTest {

    @Test
    public void testCalculator() {
        Calculator calculator = new Calculator();
        Assert.assertNull(calculator.popNum());
        Assert.assertNotNull(calculator.displayAllNums());
        calculator.pushNum(12.566);
        calculator.pushNum(Math.sqrt(2));
        Assert.assertNotNull(calculator.displayAllNums());
        Assert.assertEquals(2, calculator.getNumbers().size());
        Assert.assertNotNull(calculator.popNum());
        calculator.setNumbers(new Stack<>());
    }

}
