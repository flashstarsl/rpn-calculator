package com.liangshan.assignment.rpncalculator.enums;

/**
 * @author lianshan
 */
public enum OperationEnum {

    ADD("+", "addNumberOperation"),
    MINUS("-", "minusNumberOperation"),
    MULTIPLY("*", "multiplyNumberOperation"),
    DIVIDE("/", "divideNumberOperation"),
    SQRT("sqrt", "sqrtOperation"),
    UNDO("undo", "undoOperation"),
    REDO("redo", "redoOperation"),
    CLEAR("clear", "clearOperation");

    private String op;
    private String operation;

    OperationEnum(String op, String operation) {
        this.op = op;
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static OperationEnum getByOp(String op) {
        for (OperationEnum type : values()) {
            if (type.op.equals(op)) {
                return type;
            }
        }
        return null;
    }

}
