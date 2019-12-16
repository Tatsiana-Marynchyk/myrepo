package com.epam.infra.addition;

import com.epam.infra.operation.SimpleOperation;

public class AddOperation implements SimpleOperation<Integer> {
    public Integer doOperation(Integer o1, Integer o2) {
        return o1 + o2;
    }
}
