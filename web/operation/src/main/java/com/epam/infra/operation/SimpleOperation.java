package com.epam.infra.operation;

public interface SimpleOperation<T extends Number> {
    T doOperation(T o1, T o2);
}
