package com.liangshan.assignment.rpncalculator.bean;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;

/**
 * @author lianshan
 */
public class Calculator {

    private static final NumberFormat STORE_FORMAT = new DecimalFormat("#.###############");
    private static final NumberFormat DISPLAY_FORMAT = new DecimalFormat("#.##########");

    private Stack<String> numbers;

    public Calculator() {
        numbers = new Stack<>();
    }

    public void pushNum(double num) {
        numbers.push(STORE_FORMAT.format(num));
    }

    public Double popNum() {
        if (numbers.isEmpty()) {
            return null;
        }
        return Double.parseDouble(numbers.pop());
    }

    public Stack<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(Stack<String> numbers) {
        this.numbers = numbers;
    }

    public String displayAllNums() {
        StringBuilder display = new StringBuilder("stack: ");
        for (String number : numbers) {
            display.append(DISPLAY_FORMAT.format(Double.parseDouble(number)));
            display.append(" ");
        }
        return display.toString().trim();
    }

}
