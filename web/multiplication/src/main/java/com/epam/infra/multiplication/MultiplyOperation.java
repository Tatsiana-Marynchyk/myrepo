package com.epam.infra.multiplication;

import com.epam.infra.operation.SimpleOperation;

public class MultiplyOperation implements SimpleOperation<Integer> {
    public Integer doOperation(Integer o1, Integer o2) {
        return o1 * o2;
    }
}
