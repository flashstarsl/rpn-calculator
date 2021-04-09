package com.liangshan.assignment.rpncalculator;

import com.liangshan.assignment.rpncalculator.starter.ScannerStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RpnCalculatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(RpnCalculatorApplication.class, args);
        ((ScannerStarter)applicationContext.getBean("scannerStarter")).startProcess();
    }

}
