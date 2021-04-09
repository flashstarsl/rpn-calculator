package com.liangshan.assignment.rpncalculator;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lianshan
 */
@Configuration
public class RpnCalculatorApplicationConfiguration {

    @Value("${redo.buffer.capacity}")
    private Integer redoCapacity;

    @Bean(name = "calculator")
    public Calculator getCalculator() {
        return new Calculator();
    }

    @Bean(name = "redoBuffer")
    public RedoBuffer getRedoBuffer() {
        return new RedoBuffer(redoCapacity);
    }

}
