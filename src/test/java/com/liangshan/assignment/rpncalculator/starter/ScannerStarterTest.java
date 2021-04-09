package com.liangshan.assignment.rpncalculator.starter;

import com.liangshan.assignment.rpncalculator.bean.Calculator;
import com.liangshan.assignment.rpncalculator.bean.RedoBuffer;
import com.liangshan.assignment.rpncalculator.operation.AddNumberOperation;
import com.liangshan.assignment.rpncalculator.operation.IOperation;
import com.liangshan.assignment.rpncalculator.operation.MinusNumberOperation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * @author lianshan
 */
public class ScannerStarterTest {

    @InjectMocks
    private ScannerStarter starter = new ScannerStarter();

    @Mock
    private Calculator calculator;

    @Mock
    private RedoBuffer redoBuffer;

    @Mock
    private Map<String, IOperation> operationProxies;

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testStartProcess() throws Exception {
        Scanner scanner = new Scanner(Objects.requireNonNull(ScannerStarterTest.class.getClassLoader().getResourceAsStream("stream.txt")));
        starter.setScanner(scanner);
        when(calculator.getNumbers()).thenReturn(new Stack<>());
        doNothing().when(redoBuffer).addBuffer(any());
        AddNumberOperation operation = Mockito.mock(AddNumberOperation.class);
        MinusNumberOperation failed = Mockito.mock(MinusNumberOperation.class);
        doNothing().when(calculator).pushNum(anyDouble());
        doNothing().when(operation).operate();
        when(operationProxies.get(eq("addNumberOperation"))).thenReturn(operation);
        when(operationProxies.get(eq("minusNumberOperation"))).thenReturn(failed);
        doThrow(new InvocationTargetException(new Exception("mock"))).when(failed).operate();
        starter.startProcess();
    }

}
