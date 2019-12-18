package com.epam.infra.addition;

import org.junit.Assert;

import static org.junit.Assert.*;

public class AddOperationTest {

    @org.junit.Test
    public void doOperationTrue() {
        AddOperation operation = new AddOperation();
        Integer result = 10;
        assertEquals(result, operation.doOperation(5, 5));
    }

    @org.junit.Test
    public void doOperationFalse() {
        AddOperation operation = new AddOperation();
        Integer result = 10;
        assertNotEquals(result, operation.doOperation(5, 10));
    }

    @org.junit.Test
    public void doOperationFail() {
        AddOperation operation = new AddOperation();
        Integer result = 15;
        assertNotEquals(result, operation.doOperation(5, 10));
    }
}