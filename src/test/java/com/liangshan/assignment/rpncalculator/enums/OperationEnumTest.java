package com.liangshan.assignment.rpncalculator.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lianshan
 */
public class OperationEnumTest {

    @Test
    public void testOperationEnum() {
        OperationEnum type = OperationEnum.ADD;
        Assert.assertNotNull(type);
        Assert.assertEquals("addNumberOperation", type.getOperation());
        Assert.assertNull(OperationEnum.getByOp("aaa"));
        Assert.assertNotNull(OperationEnum.getByOp("-"));
    }

}
