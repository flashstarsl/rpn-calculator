package com.liangshan.assignment.rpncalculator.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lianshan
 */
public class RedoBuffer {

    private int endPos;

    private int redoPos;

    private int capacity;

    private List<Stack<String>> redoBuffer;

    public RedoBuffer(int capacity) {
        redoBuffer = new ArrayList<>(capacity);
        this.capacity = capacity;
        endPos = -1;
        redoPos = -1;
    }

    public void addBuffer(Stack<String> stack) {
        redoPos = (redoPos + 1) %  capacity;
        endPos = redoPos;
        Stack<String> copy = new Stack<>();
        copy.addAll(stack);
        if (endPos >= redoBuffer.size()) {
            redoBuffer.add(copy);
        } else {
            redoBuffer.set(endPos, copy);
        }
    }

    public Stack<String> undo() {
        int nextPos = (endPos + 1) % capacity;
        int headPos = redoBuffer.size() != capacity ? 0 : nextPos;
        if (redoPos == headPos) {
            return null;
        }
        redoPos = redoPos == 0 ? capacity - 1 : redoPos - 1;
        return redoBuffer.get(redoPos);
    }

    public Stack<String> redo() {
        if (redoPos == endPos) {
            return null;
        }
        redoPos = (redoPos + 1) %  capacity;
        return redoBuffer.get(redoPos);
    }

}
