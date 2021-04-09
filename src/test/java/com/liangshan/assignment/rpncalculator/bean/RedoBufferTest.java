package com.liangshan.assignment.rpncalculator.bean;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author lianshan
 */
public class RedoBufferTest {

    @Test
    public void testRedoBuffer() {
        RedoBuffer buffer = new RedoBuffer(5);
        Stack<String> stack = new Stack<>();
        stack.push("1");
        buffer.addBuffer(stack);
        stack.push("2");
        buffer.addBuffer(stack);
        buffer.redo();
        Stack<String> redo = buffer.redo();
        Assert.assertNull(redo);
        redo = buffer.undo();
        Assert.assertEquals(1, redo.size());
        redo = buffer.redo();
        Assert.assertEquals(2, redo.size());
        stack.push("3");
        buffer.addBuffer(stack);
        stack.push("4");
        buffer.addBuffer(stack);
        redo = buffer.undo();
        Assert.assertEquals(3, redo.size());
        stack.push("5");
        buffer.addBuffer(stack);
        stack.push("6");
        buffer.addBuffer(stack);
        redo = buffer.undo();
        Assert.assertEquals(5, redo.size());
        redo = buffer.redo();
        Assert.assertEquals(6, redo.size());
        stack.push("7");
        buffer.addBuffer(stack);
        stack.push("8");
        buffer.addBuffer(stack);
        redo = buffer.undo();
        Assert.assertEquals(7, redo.size());
        redo = buffer.redo();
        Assert.assertEquals(8, redo.size());
        redo = buffer.redo();
        Assert.assertNull(redo);
        redo = buffer.undo();
        Assert.assertEquals(7, redo.size());
        redo = buffer.undo();
        Assert.assertEquals(6, redo.size());
        redo = buffer.undo();
        Assert.assertEquals(5, redo.size());
        redo = buffer.undo();
        Assert.assertEquals(3, redo.size());
        redo = buffer.undo();
        Assert.assertNull(redo);
    }

}
