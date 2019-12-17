package com.epam.infra.multiplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyOperationTest {

    @Test
    public void doOperation() {
        MultiplyOperation operation = new MultiplyOperation();
        Integer result = 10;
        assertEquals(result, operation.doOperation(1, 10));
    }

    @Test
    public void doOperationNeg() {
        MultiplyOperation operation = new MultiplyOperation();
        Integer result = -25;
        assertEquals(result, operation.doOperation(5, -5));
    }
}