package com.liangshan.assignment.rpncalculator.starter;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;
import com.liangshan.assignment.rpncalculator.enums.OperationEnum;
import com.liangshan.assignment.rpncalculator.operation.IOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lianshan
 */
@Component
public class ScannerStarter {

    private Scanner scanner;

    @Autowired
    private Calculator calculator;

    @Autowired
    private RedoBuffer redoBuffer;

    @Resource(name = "operationProxies")
    private Map<String, IOperation> operationProxies;

    public ScannerStarter() {
        scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startProcess() {
        System.out.print("Start input: ");
        redoBuffer.addBuffer(calculator.getNumbers());
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            processInput(line.trim().split(" "));
        }
    }

    private void processInput(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            OperationEnum type = OperationEnum.getByOp(token);
            try {
                if (type != null) {
                    operationProxies.get(type.getOperation()).operate();
                } else {
                    calculator.pushNum(Double.parseDouble(token));
                    redoBuffer.addBuffer(calculator.getNumbers());
                }
            } catch (Exception e) {
                String msg = "";
                if (e instanceof InvocationTargetException) {
                    msg = ((InvocationTargetException) e).getTargetException().getMessage();
                }
                String errMsg = String.format("input %s (position %s): %s", token, (2 * i + 1),
                        StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : msg);
                System.out.println(errMsg);
                break;
            }
        }
        System.out.println(calculator.displayAllNums());
    }

}
